FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/ms-order-1.0.0.jar ms-order-1.0.0.jar
EXPOSE 10000
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARM} ms-order-1.0.0.jar" ]
