# filepath: /home/awungia/Downloads/demo/Dockerfile
FROM eclipse-temurin:17-jre
COPY build1/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]