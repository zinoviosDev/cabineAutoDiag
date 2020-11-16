# Docker multi-stage build
 
# 1. Building the App with Maven
FROM maven:3-jdk-11
 
ADD . /cabautodiag-spring-boot-docker
WORKDIR /cabautodiag-spring-boot-docker
 
# Just echo so we can see, if everything is there :)
RUN ls -l
 
# Run Maven build
RUN mvn clean install
 
 
# 2. Just using the build artifact and then removing the build-container
FROM openjdk:11-jdk
 
MAINTAINER Marc Siray
 
VOLUME /tmp
 
# Add Spring Boot app.jar to Container
COPY --from=0 "/cabautodiag-spring-boot-docker/target/*-SNAPSHOT.jar" app.jar
 
# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
