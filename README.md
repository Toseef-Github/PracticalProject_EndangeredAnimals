Coverage 95.8%

# Practical Project - Endangered Animals

For this project I was given the freedom to pick a topic of my choice to build a database with a functional front-end. I have chosen to make an application on endangered animals which allows users to create, read (view all or search by name), update and delete animals on the database. 

## Getting Started 

The following instructions will help you get the project running on your local device allowing development and testing. Please see deployment notes on how to deploy the project on a live system. 

## Prerequisites 

Prerequisites for the project: 

-GitBash – To clone the remote repository to your local repository. https://git-scm.com/downloads

-Jira - Atlassian Website for project planning - https://www.atlassian.com/

-MySQL WorkBench - Database - https://dev.mysql.com/downloads/windows/installer/8.0.html

-Java - Coding Language - https://www.oracle.com/uk/java/technologies/javase-downloads.html

-Eclipse - Code Editor - http://www.eclipse.org/downloads

-Visual Studio Code (Java script) - Code Editor for HTML and Programming Language; Java and JS - https://code.visualstudio.com/

-Maven/Junit/Mockito - Are used for testing through eclipse. https://maven.apache.org/download.cgi

-SpringBoot - Backend Application - https://spring.io/tools

-Postman - Testing HTTP Requests - https://www.postman.com/downloads/

-H2 Console - Remote Database - http://localhost:8080/h2-console/

-HTML/Live Server - Webpage Development - Live Server is found in the extensions section of Visual Studio Code.

-CSS/Bootstrap - Front-end Styling - https://getbootstrap.com/


## Installing Postman
Download Postman from this link - https://www.postman.com/downloads/

![image](https://user-images.githubusercontent.com/105277444/181766013-a57eaf12-0c95-4750-8283-22bfc0b32e1a.png)

Postman-Download

Open the link and run Postman and you should see the following output:

![image](https://user-images.githubusercontent.com/105277444/181766064-ec2e1f55-cd52-4512-be02-23a2754aed56.png)


## Deploying Practical Project 

Once you have cloned the repository to your local device, open eclipse on your device and select; "File: > "Open projects from file system" > select the folder cloned "PracticalProject".

Once opened, change the application-prod.properties from validate to create (Please note you will need to edit the url, username and password accordingly). Next, run the project as spring-boot project and upon completion change it back to validate.

You must also connect the MySQL local instance by selecting "connect database". 

The front-end can be opened in Visual Studio Code by using the live server plugin.

The front-end should be up and running allowing you full CRUD functionality. 

INSERT IMAGE **************

You can check if the database is holding the data correctly by opening the table in MySQL. 

MySQL_animaltable.png
***********


## Running Tests

The testing is carried out via JUnit and MockMVC. This covers the functionality of the API. To run the test just simply right click on the project and select coverage as JUnit test.

INSERT IMAGE ***************

## Continued Development:
- Separate page for the search function has been created with working search functionality. This can be implemented	 via a navigation bar. 

- Add a second entity such as charitable organisations for endangered animals as shown in the draft ERD. 

- Design improvements for the front end. 

## Built With

Maven - Dependency Management
Spring - Backend Application

## Versioning 

GitHub was used for versioning.

## Authors

- Toseef Mehdi 










