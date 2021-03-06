FROM java:8
EXPOSE 8080
ADD target/simplewebapplication.jar simplewebapplication.jar
ENTRYPOINT ["java","-jar","simplewebapplication.jar"]