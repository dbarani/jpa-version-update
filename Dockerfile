FROM amazoncorretto:21

RUN mkdir -p "/app"

WORKDIR /app

ADD application/build/libs/application-*.jar application.jar

EXPOSE 8080
CMD ["java", "-jar", "application.jar"]
