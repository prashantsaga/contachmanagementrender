FROM openjdk:17
WORKDIR /app
COPY target/contactManagement.jar .
EXPOSE 8080
CMD ["java", "-jar", "contactManagement.jar"]
