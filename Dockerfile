# --------------------------
# 1단계: 빌드
# --------------------------
FROM gradle:7.6-jdk17 AS builder

WORKDIR /app

# 소스 복사
COPY --chown=gradle:gradle . .

# gradlew 실행 권한
RUN chmod +x ./gradlew

# CI용 application.yml 환경 변수로 복사
ARG APPLICATION_YML
RUN mkdir -p src/main/resources \
    && echo "$APPLICATION_YML" > src/main/resources/application.yml

# Gradle 빌드 (fat jar 생성, 테스트 스킵)
RUN ./gradlew clean build -x test --no-daemon

# --------------------------
# 2단계: 런타임
# --------------------------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 1단계에서 생성된 jar만 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 노출
EXPOSE 8080

# JVM 옵션 + 실행
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]
