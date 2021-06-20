本Application 知识点:

  1, Spring boot admin
  http://localhost:8080/applications

  2, Swagger
  http://localhost:8080/swagger-ui/
  
  3, Bean 的 lifecycle

  4, dockerfile-maven-plugin, 可以直接上传 image, 但是要注意两点，pom.xml 密码要重新改。还有 Dockerfile 的
```xml
COPY target/${JAR_FILE} app.jar
```
是错的，不应该有 target, 但不知道为什么在此处，pom.xml 的plugin 带动下非要有target才能运作
  
  