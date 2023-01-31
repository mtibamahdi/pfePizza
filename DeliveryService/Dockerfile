FROM openjdk:11
#COPY target/*.jar app.jar
ADD target/DeliveryService-1.0.0.jar DeliveryService.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "DeliveryService.jar"]

