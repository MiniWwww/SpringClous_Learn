FROM openjdk:8-alpine
WORKDIR /app

ADD target/user-service-9090-1.0-SNAPSHOT.jar .
EXPOSE 9090

ENTRYPOINT ["java","-jar","/app/user-service-9090-1.0-SNAPSHOT.jar"]
