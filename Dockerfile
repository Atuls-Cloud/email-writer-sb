FROM maven:3.8.6-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/email-writer-sb-0.0.1-SNAPSHOT.jar email-writer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "email-writer.jar"]
