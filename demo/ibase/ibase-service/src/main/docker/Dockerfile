FROM fabric8/java-centos-openjdk8-jre

USER root
ARG ZIP_FILE
ADD ${ZIP_FILE} /deployments/incloudos
RUN chown -R jboss:root /deployments/incloudos
ENV JAVA_APP_DIR=/deployments/incloudos

USER jboss
WORKDIR /deployments
CMD [ "/deployments/run-java.sh" ]