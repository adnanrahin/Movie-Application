FROM openjdk:8-jre-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY movie-backend/target/movie-backend-*.jar /opt/movie-backend.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/movie-backend.jar
