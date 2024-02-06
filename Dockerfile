FROM openjdk:8-jre-alpine
WORKDIR /app
ENV PORT 8080
EXPOSE 8080
COPY movie-backend/target/movie-backend-*.jar movie-backend.jar
ENTRYPOINT [ "java", "-jar", "movie-backend.jar" ]
