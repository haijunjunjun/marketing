FROM java:8
VOLUME /tmp
ADD /target/controller-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]