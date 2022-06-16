FROM openjdk:8-jdk-alpine
COPY ./src src
COPY target/microservice-welcome-1.0.0-SNAPSHOT.jar microservice-welcome-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","microservice-welcome-1.0.0-SNAPSHOT.jar"]
