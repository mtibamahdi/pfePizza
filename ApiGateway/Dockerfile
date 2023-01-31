FROM openjdk:11
#COPY target/*.jar app.jar
ADD target/ApiGateway-1.0.0.jar ApiGateway.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "ApiGateway.jar"]

