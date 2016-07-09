# TripApplication

This application created base on web project from Eclipse IDE. 
Use Jersey and Maven in implement and Apache Tomcat version 8.0.35 to deploy.

##Preparation
1. Create project in https://console.developers.google.com
2. Enable BigQuery API.
3. Load data to Google Cloud Storage.
4. Create a data set in Google Big Query from loaded data in Google Cloud Storage.
5. Test SQL command in Google Big Query.

##On Local Machine

1. Clone this project and open it with Eclipse IDE.
2. Install Apache Tomcat and config it for integrating with Eclipse web project.
3. Create Google Credential with **New service account key**, and follow this instruction https://developers.google.com/identity/protocols/application-default-credentials
4. Run on Server by Eclipse. 
5. Or export project to **.war** file and put it to ***$TOMCAT_HOME/webapps*** directory. Then start Apache Tomcat.
6. <http://localhost:8080/TripApplication> will be accessible and return some data on browser.

##On Cloud Platform ( Google Compute Engine )

1. Create an instance of Google Compute Engine.
2. Set the instance to allow protocol **tcp** with port **8080** and check **Allow HTTP Traffic** in Network Setting.
3. Use SSH for connecting to the instance.
4. Install Java Development Kit 8.
5. Install Apache Tomcat version 8.0.35
6. Create Google Credential with **Compute Engine default service account**, and follow this instruction https://developers.google.com/identity/protocols/application-default-credentials
7. Put **.war** file( exported by Eclipse ) to ***$TOMCAT_HOME/webapps*** directory.
8. Start Tomcat and <http://[Server_ip]:8080/TripApplication> will be accessible and return some data on browser.