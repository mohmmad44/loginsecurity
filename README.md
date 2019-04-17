# Spring Security Project
## Steps to start the project


1. Prerequisites
  * Java 8
  * Maven 3.6
  * MySql Server 5.7
  
2. Create a database  __springsecurity__ in mysql server
 
3. Replace the mysql server credentials in properties with your credentials.
 
4. Properties file is located at /SpringSecurity/src/main/resources/application.properties
 
5. Build the Project inside the project folder /SpringSecurity
 
 ```
 mvn clean install
  ```
  
   After the build is successs.

6. Start the application by running the following command

```
java -jar target\SpringSecurity-0.0.1-SNAPSHOT.jar
```

7. Open browser and go to (http://localhost:8080)

8. To generate the documentation of the project
```
 mvn javadoc:javadoc
 ```
 
   Documents are generated in \SpringSecurity\target\site\apidocs
   and go to index.html
   
   
   
9. To get all JSON registered user details
```
http://localhost:8080/getusers
 ```
 
