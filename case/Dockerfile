FROM openjdk:8-alpine
ARG JAR_FILE=kafein-case.jar
ADD target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]