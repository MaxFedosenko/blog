FROM openjdk:19-alpine
COPY target/blog-3.0.2.jar blog.jar
ENTRYPOINT ["java", "-jar", "/blog.jar"]
