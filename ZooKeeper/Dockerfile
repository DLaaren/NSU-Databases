FROM gradle AS build
WORKDIR /app
COPY . .
RUN gradle

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ADD build/libs/zookeeper.jar /app/zookeeper.jar
ENTRYPOINT ["java", "-jar", "zookeeper.jar"]