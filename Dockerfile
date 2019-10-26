FROM openjdk:8u131-jdk-alpine

EXPOSE 8080

WORKDIR /usr/local/bin/

COPY target/CountRoomMonitoringSystem-1.0.2.jar webapp.jar

CMD ["java", "-Xmx50m","-jar","webapp.jar"]
