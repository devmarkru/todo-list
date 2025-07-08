# Use Gradle image to build the application
FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# Use JDK runtime for running the built jar
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/devmark.jar devmark.jar
CMD ["java", "-jar", "devmark.jar"]

