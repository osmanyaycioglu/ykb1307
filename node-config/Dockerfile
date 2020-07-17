FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/node-config-1.0.0.jar node-config-1.0.0.jar
EXPOSE 8888
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar -Dconfig.dir=${CONFIG_DIR} ${JAVA_PARM} node-config-1.0.0.jar" ]
