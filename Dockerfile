FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/jobSite-0.0.1-SNAPSHOT.jar jobSite-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","jobSite-0.0.1-SNAPSHOT.jar"]