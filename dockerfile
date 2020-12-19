FROM openjdk:11-jdk
MAINTAINER Jonas Hecht
ARG JAR_FILE=./target/springboot.jar
COPY target/springboot.jar springboot.jar
ENTRYPOINT ["java","-jar","/springboot.jar","--server.port=8888"]
EXPOSE 8888