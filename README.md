# oauth2-netflixZuul-springFeign-springCloud-eureka
Gateway with eureka balance and oauth2 authentication - microservices

##Technologies

- Spring security
- Oauth2
- Oauth2 client
- Spring Cloud
- Spring Feign
- Netflix Zuul
- Eureka

##Requirements
Install JDK 8

#Start docker
```
docker-compose up
```
List state
```
docker-compose ps
```

Datasource URL: jdbc:postgresql://localhost:15432/postgres

##Build and run projects

```
cd eureka
mvn clean install
mvn spring-boot:run
```
```
cd auth-service
mvn clean install
mvn spring-boot:run
```
```
cd student
mvn clean install
mvn spring-boot:run
```
```
cd teacher
mvn clean install
mvn spring-boot:run
```
```
cd school-gateway
mvn clean install
mvn spring-boot:run
```

Ports:
- eureka: 8761
- auth-service: 8081
- teacher-service: 8801
- gateway: 8080

## Create table in H2 

![H2 console](/assets/images/h2-console.png)

Create table and insert rows:

- student/src/main/resources/data.sql
- teacher/src/main/resources/data.sql

Spring Eureka console: 
http://localhost:8761/

Curl by direct service:

http://localhost:8801/3/students
```
[{"id":1,"name":"Maria","classSection":"1A","classTeacherId":3},{"id":3,"name":"Mariana","classSection":"1A","classTeacherId":3},{"id":5,"name":"Isaac","classSection":"1A","classTeacherId":3}]
```

Curl by gateway:

http://localhost:8080/teacher/3/students
```
[{"id":1,"name":"Maria","classSection":"1A","classTeacherId":3},{"id":3,"name":"Mariana","classSection":"1A","classTeacherId":3},{"id":5,"name":"Isaac","classSection":"1A","classTeacherId":3}]
```

GET TOKEN

```
curl --location --request POST 'http://localhost:8080/auth-service/oauth/token' \
--header 'Authorization: Basic d2ViYXBwOndlYnNlY3JldA==' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'username={{user}}' \
--data-urlencode 'password={{password}}' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'scope=read write'
```

GET TEACHER USING TOKEN
```
curl --location --request GET 'http://localhost:8801/teacher/1' \
--header 'Authorization: Bearer {{token}}'
```