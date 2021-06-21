# Weather UI and API Validation Test

This repository is meant for creating and executing Weather automated test cases.

Contact People for queries :

1. Vinita Kaushal

Highlights of the repo :

1. Tests in this repo covers UI and API validation of Weather.
2. High level Tech Stack used :

    a. Java & Selenium
    
    b. TestNG
    
    c. Rest-Assured

### Pre-requisite
* JDK 8
* IDE, prefer [IntelliJ Idea CE](https://www.jetbrains.com/idea/download/download-thanks.html?platform=mac&code=IIC)


### Setting up the project locally:
* `git clone https://github.com/vinitakaushal/WeatherAPI_UITest.git
* Ensure TestNG plugin is working
* Rebuild project locally using `mvn clean install`.


### Running Test Suites
* For Test Execution through IDE:
	- Goto Suites folder and right click WeatherValidation.xml and click Run As TestNG Suite
  
* For Test Execution through command:  
mvn clean test -DsuiteXmlFile=src/test/java/Suites/WeatherValidation.xml

## Reports
* <u>Local Reports</u>
    * Running tests locally , reports are stored in `/build/reports/*`.
    * Open `index.html` and 'emailable-report.html' to view the reports in a web browser 