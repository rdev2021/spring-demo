FROM gradle:jdk11 AS appbuild
WORKDIR "/home/gradle/spring-demo"
COPY --chown=gradle:gradle "./build.gradle" "/home/gradle/spring-demo"
COPY --chown=gradle:gradle "./src/" "/home/gradle/spring-demo/src/"
RUN gradle build --info
RUN ls -l /home/gradle/spring-demo/build/libs/

FROM openjdk:11-jre-slim-buster
WORKDIR "/apps"
ENV LANG en_US.UTF-8
EXPOSE 8080
COPY --from=appbuild "/home/gradle/spring-demo/build/libs/spring-demo-0.0.1-SNAPSHOT.jar" "/apps/spring-demo.jar"
CMD ["java", "-jar", "/apps/spring-demo.jar"]