FROM openjdk:8 AS build


COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package


FROM openjdk:8
WORKDIR fleet-management-system
COPY --from=build target/*.jar fleet-management-system.jar
ENTRYPOINT ["java", "-jar", "fleet-management-system.jar"]