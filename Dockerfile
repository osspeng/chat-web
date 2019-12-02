# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
MAINTAINER Rajeev Kumar Singh <callicoder@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=target/websocket-demo-0.0.1-SNAPSHOT.jar

# Active SprinBoot profile (use command instead)
# ENV SPRING_PROFILES_ACTIVE=gke

# Add the application's jar to the container
#ADD ${JAR_FILE} websocket-demo.jar
COPY target/websocket-demo-0.0.1-SNAPSHOT.jar /websocket-demo.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/websocket-demo.jar"]

