FROM openjdk:latest
COPY ./target/seMethods-0.1.1.5-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-0.1.1.5-jar-with-dependencies.jar"]