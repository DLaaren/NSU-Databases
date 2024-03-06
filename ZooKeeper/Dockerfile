FROM eclipse-temurin:21-alpine
EXPOSE 8080

WORKDIR /app
ADD build/libs/zookeeper.jar /app/zookeeper.jar
ENTRYPOINT ["java", "-jar", "zookeeper.jar"]