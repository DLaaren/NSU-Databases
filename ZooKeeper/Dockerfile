FROM gradle as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM openjdk:17-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=builder /home/gradle/src/build/libs/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]