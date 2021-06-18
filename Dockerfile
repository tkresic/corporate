FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/corporate-0.1.0.jar corporate.jar
ENTRYPOINT ["java", "-jar", "corporate.jar"]