FROM eclipse-temurin:17.0.7_7-jre-jammy
WORKDIR "/apps"
ENV LANG en_US.UTF-8
EXPOSE 8080
COPY "./build/libs/spring-demo-0.0.1-SNAPSHOT.jar" "/apps/spring-demo.jar"
CMD ["java", "-jar", "/apps/spring-demo.jar"]