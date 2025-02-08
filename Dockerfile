FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar
RUN ls -al /app
EXPOSE 8085 8080



ENTRYPOINT ["java", "-jar", "app.jar"]