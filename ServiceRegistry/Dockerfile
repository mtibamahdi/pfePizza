FROM openjdk:11
#COPY target/*.jar app.jar
ADD target/ServiceRegistry-1.0.0.jar ServiceRegistry.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/ServiceRegistry.jar"]