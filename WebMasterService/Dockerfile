FROM openjdk:11
#COPY target/*.jar app.jar
ADD target/WebMasterService-1.0.0.jar WebMasterService.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "WebMasterService.jar"]

