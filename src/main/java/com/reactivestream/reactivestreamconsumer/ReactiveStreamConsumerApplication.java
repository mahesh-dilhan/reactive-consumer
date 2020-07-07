package com.reactivestream.reactivestreamconsumer;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Log4j2
@SpringBootApplication
public class ReactiveStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveStreamConsumerApplication.class, args);
	}


}

interface PatientRepository extends ReactiveMongoRepository<Patient,String>{

}

@Log4j2
@Component
class PatientEventhandler{

	private PatientRepository patientRepository;

	public PatientEventhandler(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
		String TOPIC_NAME ="rektopic";
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "reactive-mongo-group-id");
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "reactive-mongo-client");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, PatientSerDes.class);

		ReceiverOptions<Long, Object> subscription = ReceiverOptions.<Long, Object>create(props)
				.addAssignListener(p -> log.info("Group {} partitions assigned {}", "reactive-mongo-group-id", p))
				.addRevokeListener(p -> log.info("Group {} partitions assigned {}", "reactive-mongo-group-id", p))
				.subscription(Arrays.asList(TOPIC_NAME));
		KafkaReceiver<Long, Object> kafkaReceiver = KafkaReceiver.create(subscription);


		kafkaReceiver.receive()
				.log()
				.concatMap(m ->
						save(new Patient(null,(CovidPatient) m.value()))
						.thenEmpty(
								m.receiverOffset().commit()
						))
				.retry(1)
				.log()
				.doOnError(e-> e.printStackTrace())
				.subscribe();
	}

	private Mono<Void> save(Patient patient) {
		log.info("{}"  , patient);
		 this.patientRepository
				 .save(patient)
				 .subscribe(log::info);
		 return Mono.empty();
	}


}