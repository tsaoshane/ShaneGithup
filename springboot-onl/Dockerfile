FROM openjdk:8-jre-slim
RUN mkdir /app
COPY build/libs/*.jar /app/bbsWs.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/bbsWs.jar"]