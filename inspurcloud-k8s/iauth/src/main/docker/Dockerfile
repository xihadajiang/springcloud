FROM fabric8/java-centos-openjdk8-jdk
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
# RUN bash -c 'touch app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD java -jar app.jar