FROM openjdk:21

WORKDIR /SubmitModS

ARG APP_JAR=*.jar

COPY ${APP_JAR} SubmitModS-0.0.1.jar

ENTRYPOINT ["java", "-jar", "SubmitModS-0.0.1.jar"]

EXPOSE 8080