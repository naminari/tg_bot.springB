FROM openjdk:17

WORKDIR /app

COPY build/libs/telegramBot-0.0.1-SNAPSHOT.jar app.jar
