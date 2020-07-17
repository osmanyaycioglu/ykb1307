FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/ms-accounting-1.0.0.jar ms-accounting-1.0.0.jar
EXPOSE 11000
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARM} ms-accounting-1.0.0.jar" ]
