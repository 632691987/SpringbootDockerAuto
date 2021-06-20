FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/autopublish*.jar
COPY target/${JAR_FILE} app.jar
expose 8080
ENTRYPOINT ["java","-jar","/app.jar"]