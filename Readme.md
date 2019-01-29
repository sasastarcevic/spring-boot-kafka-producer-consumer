# Spring Boot Kafka producer and consumer on Docker

### Clone project and go to folder
```
cd spring-boot-kafka-producer-consumer
```

### Build project
```
gradle clean build
```

### Build docker compose
```
docker-compose build
```
Note: Setup KAFKA_ADVERTISED_HOST_NAME in docker-compose.yml file and use same configuration in config/application-docker.yml. Need to use you IP address for Ethernet.

### Start docker enviroment
```
docker-compose up
```

### Wait until docker is started
```
spring_boot_kafka_1  | 2018-04-23 13:17:57.926  INFO 1 --- [ntainer#0-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-1, groupId=sasa-group-consumer] Successfully joined group with generation 1
spring_boot_kafka_1  | 2018-04-23 13:17:57.931  INFO 1 --- [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-1, groupId=sasa-group-consumer] Setting newly assigned partitions [message-topic00-3, message-topic00-0, message-topic00-1, message-topic00-2]
spring_boot_kafka_1  | 2018-04-23 13:17:57.999  INFO 1 --- [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : partitions assigned: [message-topic00-0]
```

### Check port for started application
```
docker-compose ps
```

### Application started on port
```
CONTAINER ID        IMAGE                                               COMMAND                  CREATED             STATUS              PORTS                                                                                NAMES
c1b42b16ce34        springbootkafkaproducerconsumer_spring_boot_kafka   "java -jar -Dsprin..."   2 minutes ago       Up 2 minutes        0.0.0.0:9090->9090/tcp                                                               springbootkafkaproducerconsumer_spring_boot_kafka_1
3f34f321fcb9        wurstmeister/kafka                                  "start-kafka.sh"         2 minutes ago       Up 2 minutes        0.0.0.0:9092->9092/tcp                                                               springbootkafkaproducerconsumer_kafka1_1
8581d8da3da4        elevy/zookeeper:latest                              "/entrypoint.sh zk..."   2 minutes ago       Up 2 minutes        0.0.0.0:2181->2181/tcp, 9010/tcp, 0.0.0.0:32788->2888/tcp, 0.0.0.0:32787->3888/tcp   springbootkafkaproducerconsumer_zoo1_1
```

### Open Swagger documentation and check is application started
```
http://localhost:9090/swagger-ui.html
```
