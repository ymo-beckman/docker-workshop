FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} workshop-demo.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/workshop-demo.jar"]
EXPOSE 18080