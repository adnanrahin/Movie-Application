FROM openjdk:8-jre-alpine
WORKDIR /app
COPY movie-backend/target/movie-backend-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "movie-backend-0.0.1-SNAPSHOT.jar" ]