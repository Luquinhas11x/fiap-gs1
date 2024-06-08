FROM maven:3.8.7-openjdk-18-slim AS build

RUN mkdir /opt/globalsolution

COPY . /opt/globalsolution

WORKDIR /opt/globalsolution

RUN mvn clean package

FROM eclipse-temurin:18-jre-alpine

RUN mkdir /opt/globalsolution

COPY --from=build  /opt/globalsolution/target/globalsolution.jar /opt/globalsolution/globalsolution.jar

WORKDIR /opt/globalsolution

ENV PROFILE=dev

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "globalsolution.jar"]