FROM openjdk:11
COPY target/appliance-web-app.jar appliance-web-app.jar
WORKDIR /tmp
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /appliance-web-app.jar"]
