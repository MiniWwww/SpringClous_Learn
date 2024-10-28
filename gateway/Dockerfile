FROM openjdk:8-alpine
WORKDIR /app

LABEL name = "cloud-sc-gateway"
ADD target/gateway-1.0-SNAPSHOT.jar .
EXPOSE 10010

ENTRYPOINT ["java","-jar","/app/gateway-1.0-SNAPSHOT.jar"]
