FROM openjdk:17.0.2
WORKDIR /app-api
COPY build/libs/employees-management-0.0.1-SNAPSHOT-plain.jar ./
ENTRYPOINT ["java","-jar","/employees-management-0.0.1-SNAPSHOT-plain.jar"]
EXPOSE 8080