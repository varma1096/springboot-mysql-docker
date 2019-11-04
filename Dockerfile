FROM openjdk:8
ADD ./target/boot-mysql.jar boot-mysql.jar
EXPOSE 8080
CMD ["java","-jar","boot-mysql.jar"]