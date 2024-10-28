FROM openjdk:8-alpine
WORKDIR /app

ADD target/comment-service-9093-1.0-SNAPSHOT.jar .
EXPOSE 9093

ENTRYPOINT ["java","-jar","/app/comment-service-9093-1.0-SNAPSHOT.jar"]
