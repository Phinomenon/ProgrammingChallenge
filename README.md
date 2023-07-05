# Prodyna Programming Challenge

The task was to implement a RESTful Webservice with CRUD for an entity called Person. In terms of technology Spring Boot, a database (MySQL or MongoDB) and a build and dependency management tool (Maven or Gradle) had to be used.

## Design Choices

For the task I chose to rely on Maven, which seemed more straightforward and MySQL, since I had more experience with it.

## Creating a Database

SQL Code used to create a fitting database:

CREATE TABLE `persons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
);

# Spring Boot Guides

## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#data.nosql.mongodb)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

