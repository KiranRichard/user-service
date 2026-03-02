#INSTALLATION OF THE OPERATING SYSTEM
FROM eclipse-temurin:17-jdk
COPY target/authorizedUser-service-0.0.1-SNAPSHOT.jar authorizedUser-service.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","authorizedUser-service.jar"]