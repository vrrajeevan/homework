
FROM openjdk:8-jre-alpine

COPY ./target/whatisdocker-1.0.1.jar /usr/src/web/
WORKDIR /usr/src/web
EXPOSE 8080
CMD ["java", "-jar", "whatisdocker-1.0.1.jar"]

 