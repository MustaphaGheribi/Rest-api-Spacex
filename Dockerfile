FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    STARTUP_SLEEP=0 \
    JAVA_OPTS=""

COPY /target/*.jar app.jar
ENTRYPOINT ["java", "-Dlog.path=/home/pm/log -Xmx400m -Xms400m", "-jar", "app.jar"]

