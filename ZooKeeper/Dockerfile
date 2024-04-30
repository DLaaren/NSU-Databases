
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ADD build/libs/*.jar /app/zookeeper.jar
ENTRYPOINT ["java", "-jar", "zookeeper.jar"]