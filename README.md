#Marvel Comics

This project is a simple Microservice code for retrieving Marvel characters ids, character details by character id and translated character description to specified language by character id. 

This project uses Spring Boot, Spring boot log4j2 and ibm watson dependencies.

### Machine Requirements
* Java 1.8
* Maven 3.3.1 or higher


### Features




### Config Requirement


```xml
<pluginRepositories>
  <pluginRepository>
    <id>comphenix-rep</id>
    <name>Comphenix Maven Releases</name>
    <url>http://repo.comphenix.net/content/groups/public</url>
  </pluginRepository>
</pluginRepositories>
```


### Build Local

```bash
$ mvn clean package       
```

### Run Local

```bash
$ mvn spring-boot:run
```

View the application running here: [http://localhost:8080](http://localhost:8080)


