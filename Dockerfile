FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY target/auth-ms.jar app.jar
EXPOSE 8080:8100
ENTRYPOINT ["java","-jar","/app.jar"]