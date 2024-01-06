FROM openjdk:8-jre-alpine
WORKDIR /app
COPY movie-backend/target/movie-backend-*.jar movie-backend.jar
ENTRYPOINT [ "java", "-jar", "movie-backend.jar" ]
