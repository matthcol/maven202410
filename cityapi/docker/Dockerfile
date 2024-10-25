FROM openjdk:21

WORKDIR /app
COPY ./artifact/cityapi.jar /app

EXPOSE 8080

CMD ["java", "-Dspring.profiles.active=pg", "-jar", "cityapi.jar"]