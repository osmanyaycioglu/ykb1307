FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/node-discovery-1.0.0.jar node-discovery-1.0.0.jar
EXPOSE 5555
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARM} node-discovery-1.0.0.jar" ]
