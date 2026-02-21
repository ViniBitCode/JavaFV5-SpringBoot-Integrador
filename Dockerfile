FROM eclipse-temurin:21-jdk-jammy
ARG JAR_FILE=target/4.5-springboot-ejercicio3-0.0.1.jar
COPY ${JAR_FILE} app_integradora.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_integradora.jar"]
