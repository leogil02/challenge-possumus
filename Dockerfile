FROM maven:3.9.6-eclipse-temurin-21 AS runtime

WORKDIR /app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run


FROM maven:3.9.6-eclipse-temurin-21 AS tests

WORKDIR /app
COPY . .
RUN mvn -B test