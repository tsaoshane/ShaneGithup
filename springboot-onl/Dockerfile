FROM openjdk:8-jre-slim
ADD build/libs/*.jar bbsWs.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","bbsWs.jar"]