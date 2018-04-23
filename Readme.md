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
Note: Setup KAFKA_ADVERTISED_HOST_NAME in docker-compose.yml file and use same configuration in config/application-docker.yml.

### Start docker enviroment
```
docker-compose up
```

### Wait until docker is started
```
spring_boot_kafka_1  | 2018-04-23 13:17:57.926  INFO 1 --- [ntainer#0-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-1, groupId=sasa-group-consumer] Successfully joined group with generation 1
spring_boot_kafka_1  | 2018-04-23 13:17:57.931  INFO 1 --- [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-1, groupId=sasa-group-consumer] Setting newly assigned partitions [message-topic00-3, message-topic00-0, message-topic00-1, message-topic00-2]
spring_boot_kafka_1  | 2018-04-23 13:17:57.999  INFO 1 --- [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : partitions assigned: [message-topic00-3, message-topic00-0, message-topic00-1, message-topic00-2]
```

### Check port for started application
```
docker-compose ps
```

### Application started on port
```
CONTAINER ID        IMAGE                                               COMMAND                  CREATED             STATUS              PORTS                                                                                NAMES
492fcb5be435        springbootkafkaproducerconsumer_spring_boot_kafka   "java -jar -Dsprin..."   29 seconds ago      Up 28 seconds       0.0.0.0:32774->9090/tcp                                                              springbootkafkap
```

### Open Swagger documentation and check is application started
```
http://localhost:32774/swagger-ui.html
```
