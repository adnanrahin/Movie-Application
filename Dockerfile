FROM openjdk:8-jre-alpine
EXPOSE 8084
WORKDIR /app
COPY movie-backend/target/movie-app-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "movie-app-0.0.1-SNAPSHOT.jar" ]
