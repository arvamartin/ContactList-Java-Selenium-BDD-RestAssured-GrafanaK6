# Contact List App

### [System Under Test (SUT)](https://thinking-tester-contact-list.herokuapp.com)
<img src="contacts.png" alt="sut.png" width="700"/>;

## Overview
This project performs end-to-end UI and API testing for a contact list application (https://thinking-tester-contact-list.herokuapp.com). It uses Selenium WebDriver for UI automation and Rest Assured for API testing. 
The framework is built with Cucumber for BDD and managed with Maven.


## Built with
**The project utilizes the following technologies and tools:**
* [![Java][Java]][java-url]
* [![Maven][Maven]][maven.url]
* [![Selenium][Selenium]][selenium-url]
* [![Rest Assured][Rest Assured]][restassured-url]

## Setup Instructions
### Prerequisites
* [![Java][Java]][java-url]
* [![Maven][Maven]][maven.url]

**Check java and maven:**
```bash
java -version
mvn -version
```
### For API tests check details here: [feature file](src/test/resources/Features/API) and here: [Steps](src/test/java/StepDefinitions/API)

## Running the Tests
* use [Runner](src/test/java/Runner.java) 

### Or

```bash
mvn test
```



[Java]:https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]:https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
[Maven]:https://img.shields.io/badge/-maven-FFA500?style=for-the-badge&logo=maven&logoColor=white
[maven.url]: https://maven.apache.org/download.cgi
[Docker]:https://img.shields.io/badge/-docker-white?style=for-the-badge&logo=docker&logoColor=blue
[docker-url]:https://www.docker.com/products/docker-desktop/
[Selenium]: https://img.shields.io/badge/-selenium-CB02A?style=for-the-badge&logo=selenium&logoColor=white
[selenium-url]: https://www.selenium.dev/
[Rest Assured]: https://img.shields.io/badge/-rest%20assured-000000?style=for-the-badge&logo=restassured&logoColor=4CAF50
[restassured-url]:https://rest-assured.io/


