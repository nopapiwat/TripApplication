# TripApplication

This application created base on web project from Eclipse IDE. 
Use Jersey and Maven in implement and Apache Tomcat version 8.0.35 to deploy.

##On Local Machine

1. Clone this project and open it with Eclipse IDE.
2. Install Apache Tomcat and config it for integrating with Eclipse web project.
3. You can modify the source code in the constructor of Query.java to make it suitable for your project.
4. Create Google Credential, and follow this instruction https://developers.google.com/identity/protocols/application-default-credentials 
5. Run on Server by Eclipse. 
6. Or export project to .war file and put it to $TOMCAT/webapps directory. 
7. <http://localhost:8080/TripApplication> will be accessible and return some data.

##On Cloud Platform

1. Install Java Development Kit 8.
2. Install Apache Tomcat.
3. Create Google Credential, and follow this instruction https://developers.google.com/identity/protocols/application-default-credentials
4. Put .war file( export by Eclipse ) to $TOMCAT/webapps directory.
5. Start Tomcat and <http://[Server_ip]:8080/TripApplication> will be accessible and return some data.