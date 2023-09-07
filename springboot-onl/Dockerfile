FROM openjdk:8-jdk-alpine
MAINTAINER shane "2023/09/01"
RUN mkdir /app
WORKDIR /app
COPY bbsWs.jar bbsWs.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/bbsWs.jar"]