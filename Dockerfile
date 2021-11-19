FROM openjdk:latest

MAINTAINER Felipe Paiva Simone

RUN mkdir -p /opt/spring-boot-account-manager

ENV PROJECT_HOME /opt/spring-boot-account-manager

COPY ./target/spring-boot-account-manager-0.0.1-SNAPSHOT.jar $PROJECT_HOME

WORKDIR $PROJECT_HOME

ENTRYPOINT ["java", "-jar", "spring-boot-account-manager-0.0.1-SNAPSHOT.jar"]