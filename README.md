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
Install JDK 11

##Build and run projects

```
cd eureka
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

## Create table in H2 

![H2 console](/assets/images/h2-console.png)

Create table and insert rows:

- student/src/main/resources/data.sql
- teacher/src/main/resources/data.sql

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
