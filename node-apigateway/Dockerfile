FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/node-apigateway-1.0.0.jar node-apigateway-1.0.0.jar
EXPOSE 8080
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARM} node-apigateway-1.0.0.jar" ]
