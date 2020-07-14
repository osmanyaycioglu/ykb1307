FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/first-boot-project-1.0.0.jar first-boot-project-1.0.0.jar
EXPOSE 8090
ENV JAVA_PARM="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARM} first-boot-project-1.0.0.jar" ]
