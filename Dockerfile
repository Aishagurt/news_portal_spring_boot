FROM openjdk:20-jdk
ADD build/libs/*.jar dockerapp.jar
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]