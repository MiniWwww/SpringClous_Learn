FROM openjdk:8-alpine
WORKDIR /app

ADD target/product-service-9094-1.0-SNAPSHOT.jar .
EXPOSE 9094

ENTRYPOINT ["java","-jar","/app/product-service-9094-1.0-SNAPSHOT.jar"]
