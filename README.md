# Contact List App

### [System Under Test (SUT)](https://thinking-tester-contact-list.herokuapp.com)
<img src="contacts.png" alt="sut.png" width="700"/>;

## Overview
This project performs end-to-end **UI, API and Performance** testing for a contact list application (https://thinking-tester-contact-list.herokuapp.com). It uses Selenium WebDriver for UI automation and Rest Assured for API testing. 
The framework is built with **Cucumber for BDD** and managed with Maven.


## Built with
**The project utilizes the following technologies and tools:**
* [![Java][Java]][java-url]
* [![Maven][Maven]][maven.url]
* [![Selenium][Selenium]][selenium-url]
* [![CUCUMBER][CUCUMBER]][CUCUMBER-URL]
* [![Rest Assured][Rest Assured]][restassured-url]
* [![Grafana K6][Grafana K6]][Grafana-k6-url]

## Setup Instructions
### Prerequisites
* [![Java][Java]][java-url]
* [![Maven][Maven]][maven.url]
* [![Grafana K6][Grafana K6]][Grafana-k6-url]

**Check the installed Java and Maven versions, run the following command:**
```bash
java -version
mvn -version
k6 version
```

## Running the Tests
### for UI and API tests:

**use [Runner](src/test/java/Runner.java)**

### Or

```bash
mvn test -Dcucumber
```

### for performance tests:
* 1st
    ```bash
    cd Performance
    ```
* Then
    ```bash
    k6 run loadtest.js
    ```
    or
    ```bash
    k6 run stressTest.js
    ```

### For API tests check details here: [feature file](src/test/resources/Features/API) and here: [Steps](src/test/java/StepDefinitions/API)
### For Performance tests: [Performance](Performance)
### For UI tests: [feature file](src/test/resources/Features/UI) and here: [Steps](src/test/java/StepDefinitions/UI)




[Java]:https://img.shields.io/badge/Java23-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]:https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html
[Maven]:https://img.shields.io/badge/-maven-FFA500?style=for-the-badge&logo=maven&logoColor=white
[maven.url]: https://maven.apache.org/download.cgi
[Docker]:https://img.shields.io/badge/-docker-white?style=for-the-badge&logo=docker&logoColor=blue
[docker-url]:https://www.docker.com/products/docker-desktop/
[Selenium]: https://img.shields.io/badge/-selenium-CB02A?style=for-the-badge&logo=selenium&logoColor=white
[selenium-url]: https://www.selenium.dev/
[Rest Assured]: https://img.shields.io/badge/-rest%20assured-000000?style=for-the-badge&logo=restassured&logoColor=4CAF50
[restassured-url]:https://rest-assured.io/
[Cucumber]: https://camo.githubusercontent.com/788fbe630f1bafea0c87198f6e3e24e3f03eeef9899248581afc757f11ff5054/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f437563756d6265722d3433423032413f7374796c653d666f722d7468652d6261646765266c6f676f3d637563756d626572266c6f676f436f6c6f723d7768697465
[CUCUMBER-URL]: https://cucumber.io/
[Grafana K6]:https://img.shields.io/badge/grafana-%23F46800.svg?style=for-the-badge&logo=grafana&logoColor=white
[Grafana-k6-url]:https://grafana.com/docs/k6/latest/set-up/install-k6/


