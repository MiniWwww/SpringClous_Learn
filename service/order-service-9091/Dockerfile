FROM openjdk:8-alpine
WORKDIR /app

ADD target/order-service-9091-1.0-SNAPSHOT.jar .
EXPOSE 9091

ENTRYPOINT ["java","-jar","/app/order-service-9091-1.0-SNAPSHOT.jar"]
