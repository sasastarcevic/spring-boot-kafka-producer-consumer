FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/spring-boot-kafka-producer-consumer-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","app.jar"]