# spring-boot-experiment
Testing and experimentation with Spring applications (and related technologies).



Initial setup for the db:

--Login as a super user and run--
CREATE DATABASE spring_experiment;
CREATE USER spring_experiment WITH PASSWORD '';
GRANT ALL PRIVILEGES ON DATABASE "spring_experiment" to spring_experiment;
\connect spring_experiment
CREATE EXTENSION "uuid-ossp";