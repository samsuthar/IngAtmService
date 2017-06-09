IngAtmService is a Spring Boot MVC application that is responsible for providing Rest Endpoints to client using Spring
Security.  The web application invokes an external service to gather a super set of the data:

https://www.ing.nl/api/locator/alms

Technology Stacks:
Spring boot
Used Spring Initializer
- jQuery
-Database.js
- Maven
- JAVA 7
- Tomcat 7 Web Server
- Apache Camel

Controllers :
ServiceController.java : has two rest endpoints
- /locations : Lists all the Service addresses exposed by Locator service as a JSON respone.
- /locations/{city} : Lists all locations based on provided city as a proper JSON response.

Run Instructions:
- mvn clean spring-boot: run
- mvn clean install

Deploy application on Tomcat 8.0
Web application is on :  http://localhost:8080/IngAtmService/login
user name: user,  password: password
