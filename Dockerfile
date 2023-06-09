FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gatewayapp.jar
ENTRYPOINT ["java","-jar","/gatewayapp.jar"]