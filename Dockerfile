FROM eclipse-temurin:17-jre-alpine
COPY build/libs/springsecurityboot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar", "--bind", "0.0.0.0:8000"]