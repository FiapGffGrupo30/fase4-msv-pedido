#
# Build
#
FROM maven:3.9.6-eclipse-temurin-21-alpine as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package
#
FROM eclipse-temurin:21-jdk-alpine
ENV MONGO_USER=gff-nosql
ENV MONGO_PASS=j0Oj1LfMZzfvkpRy
VOLUME /tmp
COPY --from=build home/app/target/*.jar app.jar
ENV JVM_ARGS="-Dspring.profiles.active=prod"
ENTRYPOINT ["java","-jar","${JVM_ARGS}","/app.jar"]