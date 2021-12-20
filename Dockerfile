FROM openjdk:8-jre

COPY target/demo-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar --server.address=0.0.0.0"]
