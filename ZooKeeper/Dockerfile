FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ADD build/libs/zookeeper.jar /app/zookeeper.jar
ENTRYPOINT ["java", "-jar", "/app/zookeeper.jar"]