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
Docker
Maven

#Start docker
```shell
$ docker-compose up
```
List state
```shell
$ docker-compose ps
```

Datasource URL: jdbc:postgresql://localhost:15432/postgres

##Build and run projects

```shell
$ cd eureka
$ mvn clean install
$ mvn spring-boot:run
```
```shell
$ cd auth-service
$ mvn clean install
$ mvn spring-boot:run
```
```shell
$ cd student
$ mvn clean install
$ mvn spring-boot:run
```
```shell
$ cd teacher
$ mvn clean install
$ mvn spring-boot:run
```
```shell
$ cd school-gateway
$ mvn clean install
$ mvn spring-boot:run
```

Ports:
- eureka: 8761
- auth-service: 8081
- teacher-service: 8801
- gateway: 8080

## Create tables student and teacher in H2 

![H2 console](/assets/images/h2-console.png)

Create table and insert rows:

- student/src/main/resources/data.sql
- teacher/src/main/resources/data.sql

## Create table to login in postgres (docker image)

![Postgres](/assets/images/postgres.PNG)

```sqldelight
CREATE TABLE public.roles (
roleid serial4 NOT NULL,
"name" varchar(45) NOT NULL,
userid int4 NOT NULL,
CONSTRAINT roles_pkey PRIMARY KEY (roleid)
);
```

```sqldelight
CREATE TABLE public.users (
userid serial4 NOT NULL,
dob date NOT NULL,
email varchar(45) NOT NULL,
firstname varchar(45) NOT NULL,
gender varchar(10) NOT NULL,
lastname varchar(45) NOT NULL,
mobilenumber varchar(45) NOT NULL,
"password" varchar(100) NOT NULL,
CONSTRAINT users_pkey PRIMARY KEY (userid)
);
```

Spring Eureka console: 
http://localhost:8761/

Curl by direct service:

http://localhost:8801/3/students
```json
[{"id":1,"name":"Maria","classSection":"1A","classTeacherId":3},{"id":3,"name":"Mariana","classSection":"1A","classTeacherId":3},{"id":5,"name":"Isaac","classSection":"1A","classTeacherId":3}]
```

Curl by gateway:

http://localhost:8080/teacher/3/students
```json
[{"id":1,"name":"Maria","classSection":"1A","classTeacherId":3},{"id":3,"name":"Mariana","classSection":"1A","classTeacherId":3},{"id":5,"name":"Isaac","classSection":"1A","classTeacherId":3}]
```

GET TOKEN

```shell
$ curl --location --request POST 'http://localhost:8080/auth-service/oauth/token' \
--header 'Authorization: Basic d2ViYXBwOndlYnNlY3JldA==' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'username={{user}}' \
--data-urlencode 'password={{password}}' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'scope=read write'
```

GET TEACHER USING TOKEN
```shell
$ curl --location --request GET 'http://localhost:8801/teacher/1' \
--header 'Authorization: Bearer {{token}}'
```