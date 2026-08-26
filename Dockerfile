FROM maven:4.0.0-rc-4-amazoncorretto-21-debian AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]