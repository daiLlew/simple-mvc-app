FROM java:8
MAINTAINER dai_Llew
EXPOSE 8080
ADD ./target/simple-mvc-app-1.0-SNAPSHOT.jar /mvc-app/mvc-app.jar
WORKDIR /mvc-app