# spring-boot-experiment
Testing and experimentation with Spring applications (and related technologies). 
This project is intended as a starting point for building working Spring-Boo projects.


If you want to run this project you will need to set up a Postgres Database.

(0) Install / have access to a Postgres Database

You'll have to figure this one out on your own :)

(1)  update the database parameters (If needed)

Look at application.properties and make sure you are happy with the choices for the database.
ie the project assumes there will be a locally accessible database which has a user name spring_experiment etc.

(2) Initial setup for the db:

Login in to the database and run the following commands 

CREATE DATABASE spring_experiment;
CREATE USER spring_experiment WITH PASSWORD '';
GRANT ALL PRIVILEGES ON DATABASE "spring_experiment" to spring_experiment;
\connect spring_experiment
CREATE EXTENSION "uuid-ossp";

(3) Run flyway migration

run "gradlew flyMigration"