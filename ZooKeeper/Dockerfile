FROM gradle:jdk17-alpine as builder
WORKDIR /app
COPY . /app
RUN gradle --no-daemon build --stacktrace -x test

FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080

WORKDIR /app
COPY --from=builder /app/build/libs/zookeeper.jar zookeeper.jar
ENTRYPOINT ["java", "-jar", "zookeeper.jar"]
