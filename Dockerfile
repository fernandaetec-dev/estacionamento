FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Copia todos os ficheiros do projeto para o contentor
COPY . .

# Executa a limpeza e compilação do projeto com o Maven Wrapper (mvnw)
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

# O Maven gera o ficheiro .jar dentro da pasta /target (em vez de /build/libs)
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
