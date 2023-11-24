FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/jobSite-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","jobsite-0.0.1.SNAPSHOT.jar"]


