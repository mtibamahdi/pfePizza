FROM openjdk:11
#COPY target/*.jar app.jar
ADD target/CustomersService-1.0.0.jar CustomersService.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "CustomersService.jar"]

