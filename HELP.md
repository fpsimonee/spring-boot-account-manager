# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/#build-image)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#boot-features-redis)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)



### Dependencies 
* Docker and docker compose installed on machine
* Java 11 
* Maven installed in the machine



### Instruction to run this application
* First you need to start a redis server in docker, to do this you need to open the folder of project on prompt and run this command: 

``` shell
docker-compose up
```

* after this you run this project on your ide and can see a documentation on: 

http://localhost:8080/swagger-ui