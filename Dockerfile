FROM maven:3.9.1-eclipse-temurin-20 as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:20-jre-alpine
COPY --from=build /app/Client/target/*.jar /app/client.jar
COPY --from=build /app/TextProvider/target/*.jar /app/provicer.jar
COPY --from=build /app/TextService/target/*.jar /app/service.jar

ENTRYPOINT java --module-path /app:/app/lib/service.jar:/app/lib/provider.jar -m Client/se.iths.client.Main
