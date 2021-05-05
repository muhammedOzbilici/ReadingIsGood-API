FROM openjdk:11
ADD target/ReadingIsGood-API.jar ReadingIsGood-API.jar
EXPOSE 8484
ENTRYPOINT ["java","-jar","ReadingIsGood-API.jar"]