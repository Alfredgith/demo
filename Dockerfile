FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

# Build happens on Render (not your PC)
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Use wildcard so jar name doesn't matter
CMD ["sh", "-c", "java -jar target/*.jar"]