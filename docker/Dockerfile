FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY ../target/z-admin-0.0.1-SNAPSHOT.jar app.jar

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxRAMPercentage=75"

EXPOSE 8888

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
