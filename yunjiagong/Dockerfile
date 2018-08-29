FROM java:8
VOLUME /tmp
ADD /build/libs/yunjiagong-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 8087
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]