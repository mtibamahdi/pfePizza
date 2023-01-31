FROM openjdk:11
#COPY target/*.jar app.jar
ADD target/RestaurantOwner-1.0.0.jar RestaurantOwner.jar
EXPOSE 8005
ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar", "RestaurantOwner.jar"]

