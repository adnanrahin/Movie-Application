FROM openjdk:8-jre-alpine
WORKDIR /app
COPY movie-backend/target/movie-backend-1.0.0-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "movie-backend-1.0.0-SNAPSHOT.jar" ]
