FROM openjdk:8

EXPOSE 8080

COPY /target/onboard-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]