# HTTPS using Spring Boot  and Spring Security

## What's this?
 This project demonstrates HTTPS using Spring Boot and Spring Security
  
## How to run this?
1. Create database `httpsspringsecurity` in MySql server
2. Go to **src/main/java/resources/keystore** folder and create `pavanjadda.p12` file using the following command
```
$ keytool -genkeypair -alias pavanjadda -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore pavanjadda.p12 -validity 3650
```
3. Now run the project. All the tables required are created
4. Go to `src/main/java/resources/sql` and copy commands from the file **User Data SQL commands.sql** and run it on Mysql database
5. Now go to the following url : https://localhost:8443/api/v2/category/list and enter credentials **admin** and **admin**

