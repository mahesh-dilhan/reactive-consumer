# Reactive Kafka Receiver and MongoDB
Reactive Eventual Consistency


# Kafka Consumer
Examples in this repo:

 * Kafka Message Receiver
 * Persist payload to Mongodb


### Dependency 
Setup reactive-stream repo

## Setup & build

OpenJDK 13 (let jenv to manage multiple JDKs )

setup `zookeeper` and `kafka` in hardway. (Easy way is to use confluent binary). 
I used hardway for this setup to get hands on experience. 

### Start Zookeeper
```
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
```

### Start Kafka
```
kafka-server-start /usr/local/etc/kafka/server.properties
```

Run `mvn package` to build a single executable JAR file.

```
 /Library/Java/JavaVirtualMachines/adoptopenjdk-13.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=58133:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/mahesh/play/stream/reactive-stream-consumer/target/classes:/Users/mahesh/.m2/repository/org/projectlombok/lombok/1.18.12/lombok-1.18.12.jar:/Users/mahesh/.m2/repository/org/springframework/kafka/spring-kafka/2.5.2.RELEASE/spring-kafka-2.5.2.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-context/5.2.7.RELEASE/spring-context-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-aop/5.2.7.RELEASE/spring-aop-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-beans/5.2.7.RELEASE/spring-beans-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-expression/5.2.7.RELEASE/spring-expression-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-messaging/5.2.7.RELEASE/spring-messaging-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-tx/5.2.7.RELEASE/spring-tx-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/retry/spring-retry/1.2.5.RELEASE/spring-retry-1.2.5.RELEASE.jar:/Users/mahesh/.m2/repository/org/apache/kafka/kafka-clients/2.5.0/kafka-clients-2.5.0.jar:/Users/mahesh/.m2/repository/com/github/luben/zstd-jni/1.4.4-7/zstd-jni-1.4.4-7.jar:/Users/mahesh/.m2/repository/org/lz4/lz4-java/1.7.1/lz4-java-1.7.1.jar:/Users/mahesh/.m2/repository/org/xerial/snappy/snappy-java/1.1.7.3/snappy-java-1.1.7.3.jar:/Users/mahesh/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar:/Users/mahesh/.m2/repository/io/projectreactor/kafka/reactor-kafka/1.2.2.RELEASE/reactor-kafka-1.2.2.RELEASE.jar:/Users/mahesh/.m2/repository/io/projectreactor/reactor-core/3.3.6.RELEASE/reactor-core-3.3.6.RELEASE.jar:/Users/mahesh/.m2/repository/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar:/Users/mahesh/.m2/repository/org/springframework/boot/spring-boot-starter-data-mongodb-reactive/2.3.1.RELEASE/spring-boot-starter-data-mongodb-reactive-2.3.1.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/boot/spring-boot-starter/2.3.1.RELEASE/spring-boot-starter-2.3.1.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/boot/spring-boot/2.3.1.RELEASE/spring-boot-2.3.1.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.3.1.RELEASE/spring-boot-autoconfigure-2.3.1.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.3.1.RELEASE/spring-boot-starter-logging-2.3.1.RELEASE.jar:/Users/mahesh/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/Users/mahesh/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/Users/mahesh/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.13.3/log4j-to-slf4j-2.13.3.jar:/Users/mahesh/.m2/repository/org/apache/logging/log4j/log4j-api/2.13.3/log4j-api-2.13.3.jar:/Users/mahesh/.m2/repository/org/slf4j/jul-to-slf4j/1.7.30/jul-to-slf4j-1.7.30.jar:/Users/mahesh/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar:/Users/mahesh/.m2/repository/org/yaml/snakeyaml/1.26/snakeyaml-1.26.jar:/Users/mahesh/.m2/repository/org/mongodb/mongodb-driver-reactivestreams/4.0.4/mongodb-driver-reactivestreams-4.0.4.jar:/Users/mahesh/.m2/repository/org/mongodb/bson/4.0.4/bson-4.0.4.jar:/Users/mahesh/.m2/repository/org/mongodb/mongodb-driver-core/4.0.4/mongodb-driver-core-4.0.4.jar:/Users/mahesh/.m2/repository/org/springframework/data/spring-data-mongodb/3.0.1.RELEASE/spring-data-mongodb-3.0.1.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/data/spring-data-commons/2.3.1.RELEASE/spring-data-commons-2.3.1.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-core/5.2.7.RELEASE/spring-core-5.2.7.RELEASE.jar:/Users/mahesh/.m2/repository/org/springframework/spring-jcl/5.2.7.RELEASE/spring-jcl-5.2.7.RELEASE.jar com.reactivestream.reactivestreamconsumer.ReactiveStreamConsumerApplication
 
   .   ____          _            __ _ _
  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
 ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
   '  |____| .__|_| |_|_| |_\__, | / / / /
  =========|_|==============|___/=/_/_/_/
  :: Spring Boot ::        (v2.3.1.RELEASE)
 
 2020-07-07 20:02:12.681  INFO 42933 --- [           main] c.r.r.ReactiveStreamConsumerApplication  : Starting ReactiveStreamConsumerApplication on Maheshs-MBP with PID 42933 (/Users/mahesh/play/stream/reactive-stream-consumer/target/classes started by mahesh in /Users/mahesh/play/stream/reactive-stream-consumer)
 2020-07-07 20:02:12.683  INFO 42933 --- [           main] c.r.r.ReactiveStreamConsumerApplication  : No active profile set, falling back to default profiles: default
 2020-07-07 20:02:12.985  INFO 42933 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Reactive MongoDB repositories in DEFAULT mode.
 2020-07-07 20:02:13.129  INFO 42933 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 140ms. Found 1 Reactive MongoDB repository interfaces.
 2020-07-07 20:02:13.375  INFO 42933 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms'}
 2020-07-07 20:02:13.465  INFO 42933 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:10}] to localhost:27017
 2020-07-07 20:02:13.471  INFO 42933 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=8, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=4209693}
 2020-07-07 20:02:13.667  INFO 42933 --- [           main] reactor.Flux.Retry.2                     : onSubscribe(FluxRetry.RetrySubscriber)
 2020-07-07 20:02:13.668  INFO 42933 --- [           main] reactor.Flux.Retry.2                     : request(unbounded)
 2020-07-07 20:02:13.678  INFO 42933 --- [           main] reactor.Flux.Map.1                       : onSubscribe(FluxMap.MapSubscriber)
 2020-07-07 20:02:13.678  INFO 42933 --- [           main] reactor.Flux.Map.1                       : request(32)
 2020-07-07 20:02:13.692  INFO 42933 --- [ongo-group-id-1] o.a.k.clients.consumer.ConsumerConfig    : ConsumerConfig values: 
 	allow.auto.create.topics = true
 	auto.commit.interval.ms = 5000
 	auto.offset.reset = latest
 	bootstrap.servers = [localhost:9092]
 	check.crcs = true
 	client.dns.lookup = default
 	client.id = reactive-mongo-client
 	client.rack = 
 	connections.max.idle.ms = 540000
 	default.api.timeout.ms = 60000
 	enable.auto.commit = false
 	exclude.internal.topics = true
 	fetch.max.bytes = 52428800
 	fetch.max.wait.ms = 500
 	fetch.min.bytes = 1
 	group.id = reactive-mongo-group-id
 	group.instance.id = null
 	heartbeat.interval.ms = 3000
 	interceptor.classes = []
 	internal.leave.group.on.close = true
 	isolation.level = read_uncommitted
 	key.deserializer = class org.apache.kafka.common.serialization.LongDeserializer
 	max.partition.fetch.bytes = 1048576
 	max.poll.interval.ms = 300000
 	max.poll.records = 500
 	metadata.max.age.ms = 300000
 	metric.reporters = []
 	metrics.num.samples = 2
 	metrics.recording.level = INFO
 	metrics.sample.window.ms = 30000
 	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
 	receive.buffer.bytes = 65536
 	reconnect.backoff.max.ms = 1000
 	reconnect.backoff.ms = 50
 	request.timeout.ms = 30000
 	retry.backoff.ms = 100
 	sasl.client.callback.handler.class = null
 	sasl.jaas.config = null
 	sasl.kerberos.kinit.cmd = /usr/bin/kinit
 	sasl.kerberos.min.time.before.relogin = 60000
 	sasl.kerberos.service.name = null
 	sasl.kerberos.ticket.renew.jitter = 0.05
 	sasl.kerberos.ticket.renew.window.factor = 0.8
 	sasl.login.callback.handler.class = null
 	sasl.login.class = null
 	sasl.login.refresh.buffer.seconds = 300
 	sasl.login.refresh.min.period.seconds = 60
 	sasl.login.refresh.window.factor = 0.8
 	sasl.login.refresh.window.jitter = 0.05
 	sasl.mechanism = GSSAPI
 	security.protocol = PLAINTEXT
 	security.providers = null
 	send.buffer.bytes = 131072
 	session.timeout.ms = 10000
 	ssl.cipher.suites = null
 	ssl.enabled.protocols = [TLSv1.2]
 	ssl.endpoint.identification.algorithm = https
 	ssl.key.password = null
 	ssl.keymanager.algorithm = SunX509
 	ssl.keystore.location = null
 	ssl.keystore.password = null
 	ssl.keystore.type = JKS
 	ssl.protocol = TLSv1.2
 	ssl.provider = null
 	ssl.secure.random.implementation = null
 	ssl.trustmanager.algorithm = PKIX
 	ssl.truststore.location = null
 	ssl.truststore.password = null
 	ssl.truststore.type = JKS
 	value.deserializer = class com.reactivestream.reactivestreamconsumer.PatientSerDes
 
 2020-07-07 20:02:13.762  INFO 42933 --- [           main] c.r.r.ReactiveStreamConsumerApplication  : Started ReactiveStreamConsumerApplication in 1.389 seconds (JVM running for 1.834)
 2020-07-07 20:02:13.797  INFO 42933 --- [ongo-group-id-1] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.5.0
 2020-07-07 20:02:13.797  INFO 42933 --- [ongo-group-id-1] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 66563e712b0b9f84
 2020-07-07 20:02:13.797  INFO 42933 --- [ongo-group-id-1] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1594123333796
 2020-07-07 20:02:13.799  INFO 42933 --- [ongo-group-id-1] o.a.k.clients.consumer.KafkaConsumer     : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Subscribed to topic(s): rektopic
 2020-07-07 20:02:13.998  INFO 42933 --- [ongo-group-id-1] org.apache.kafka.clients.Metadata        : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Cluster ID: MehXd5CVQeOtxXQR6yCaWg
 2020-07-07 20:02:14.000  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Discovered group coordinator maheshs-mbp:9092 (id: 2147483647 rack: null)
 2020-07-07 20:02:14.003  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] (Re-)joining group
 2020-07-07 20:02:14.014  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Join group failed with org.apache.kafka.common.errors.MemberIdRequiredException: The group member needs to have a valid member id before actually entering a consumer group
 2020-07-07 20:02:14.014  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] (Re-)joining group
 2020-07-07 20:02:15.350  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Finished assignment for group at generation 18: {reactive-mongo-client-b03a5499-f279-45fa-97a5-7f2ab7002db7=Assignment(partitions=[rektopic-0])}
 2020-07-07 20:02:15.354  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Successfully joined group with generation 18
 2020-07-07 20:02:15.357  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Adding newly assigned partitions: rektopic-0
 2020-07-07 20:02:15.360  INFO 42933 --- [ongo-group-id-1] c.r.r.PatientEventhandler                : Group reactive-group-id partitions assigned [rektopic-0]
 2020-07-07 20:02:15.367  INFO 42933 --- [ongo-group-id-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=reactive-mongo-client, groupId=reactive-mongo-group-id] Setting offset for partition rektopic-0 to the committed offset FetchPosition{offset=8259, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[maheshs-mbp:9092 (id: 0 rack: null)], epoch=0}}

```

### Mongo DB Output
```
> db.patient.find();
{ "_id" : ObjectId("5f045d84a1cedc03e899f2e8"), "covidPatient" : { "_id" : NumberLong(1), "name" : "Maria", "country" : "SG" }, "_class" : "com.reactivestream.reactivestreamconsumer.Patient" }
{ "_id" : ObjectId("5f045edda1cedc03e899f2e9"), "covidPatient" : { "_id" : NumberLong(13), "name" : "Ali", "country" : "MY" }, "_class" : "com.reactivestream.reactivestreamconsumer.Patient" }
{ "_id" : ObjectId("5f045edda1cedc03e899f2ea"), "covidPatient" : { "_id" : NumberLong(13), "name" : "Ali", "country" : "MY" }, "_class" : "com.reactivestream.reactivestreamconsumer.Patient" }
{ "_id" : ObjectId("5f045edda1cedc03e899f2eb"), "covidPatient" : { "_id" : NumberLong(13), "name" : "Ali", "country" : "MY" }, "_class" : "com.reactivestream.reactivestreamconsumer.Patient" }
```


Console Output which shows 

```
2020-07-07 20:06:07.882  INFO 42966 --- [     parallel-2] reactor.Flux.Map.1                       : onNext(ConsumerRecord(topic = rektopic, partition = 0, leaderEpoch = null, offset = 8260, CreateTime = 1594123567765, serialized key size = -1, serialized value size = 47, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = CovidPatient(id=3, name=Smith, country=UK)))
2020-07-07 20:06:07.886  INFO 42966 --- [     parallel-2] c.r.r.PatientEventhandler                : Patient(mid=null, covidPatient=CovidPatient(id=3, name=Smith, country=UK))
2020-07-07 20:06:07.952  INFO 42966 --- [      Thread-78] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:13}] to localhost:27017
2020-07-07 20:06:07.965  INFO 42966 --- [      Thread-79] c.r.r.PatientEventhandler                : Patient(mid=5f04652f1b30c2713e8b7fb7, covidPatient=CovidPatient(id=3, name=Smith, country=UK))

```
