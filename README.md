# Spring Boot Rest API for Counter Services

This project contains APIs for crud operations related to Counter.

# Building the application
If you are doing any changes in the code then make sure you use new version in the pom.xml file (<version>0.0.3-SNAPSHOT</version>).
Also mention the same verion in the docker compose file at below location
${project_dir}/docker-compose.yaml

Use below command to build the coker image
**mvn spring-boot:build-image**

If you are not making any changes to the code, please go ahead with the installation steps directly.

# Installation
This project is using docker compose to install and run the application, so you can follow below steps to install and run.

Please make sure you have docker and docker compose installed.

$ docker --version
Docker version 20.10.12, build e91ed57

docker-compose  --version
docker-compose version 1.29.2, build 5becea4c

If it looks good then go to project directory and execute the YAML file,
**${project_dir}/docker-compose up**

You should see docker image is being downloaded and it will start running the application once image is downloaded.

# Database Details
This application uses **In-Memory database H2** and to access it over UI you can use below link ,

http://localhost:5000/h2/login.do?

Connection String  - jdbc:h2:mem:counterdb
Username - sa
Password - password

Database Schema and master data can be found at below location,

/counterservice/src/main/resources/schema.sql - Execute this manually from H2 UI IF it is not executed by the application

Content - 

CREATE SCHEMA  IF NOT EXISTS counterdb AUTHORIZATION sa;
CREATE TABLE COUNTER (COUNTER_ID INT NOT NULL, COUNTER_DESC VARCHAR(200) NOT NULL,COUNTER_VALUE INT NOT NULL,PRIMARY KEY("COUNTER_ID"));


# API Details
To see the exposed APIs by this application you can go to below link,

http://localhost:5000/swagger-ui.html#

You can even test the APIs from the above link.

# Testing the application API
You can use Postman for testing the APIs. Attaching below the postman project.

[CounterService.postman_collection.json.zip](https://github.com/swwapnily4io/counterservice/files/9033087/CounterService.postman_collection.json.zip)


