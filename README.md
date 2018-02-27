# Spring RESTful Application
A RESTful API Application built on Spring Framework. When running this application a command line runner will be excetuted in order to populate the in-memory SQL database with entries from a JSON file. The resource of REST API is **People**, which will response JSON structure data based on endpoints.

## Technologies used:
  * Language: **Java**
  * Development Kit: **Java SDK 8**
  * Framework: **Spring Framework**
  * Build Automation Tool: **Apache Maven**
  * Database: **H2 (In-Memory)**
  * ORM: **Hibernate**
  * Unit Testing Framework: **JUnit**
  * Service API: **REST**
  * REST Testing Library: **REST Assured**
  * IDE: **IntelliJ IDEA (Ultimate Edition)**

## Getting Started
These instructions will get you a copy of the project up and running on you local machine for development and testing purposes.

## Local Installation
### Prerequisites
  * Java SDK 8
  * Apache Maven
  * Spring Boot
  * Git
  * IntelliJ IDEA (Optional)
  
## Installing and Running Application
Please follow carefully step by step instructions below in order to get the app up and running locally.

1. Open Terminal

2. Get a clone of this project in local machine:
 ```
 git clone https://github.com/arianithetemi/spring-rest-app.git
 cd spring-rest-app.git
 ```
* Running application with IDE:
   - Open this project folder with any Java IDE (IntelliJ IDEA recommended)
   - Run the application using IDE Run Option
   
* Running the application with Command line:
   - Open Terminal
   - Change Directory to the project directory in terminal
   - Run the command below:
 ```
  sudo mvn spring-boot:run
 ```
 
**Note: After running the application please read the API documentation below the "Running Test Section"**
## Running Tests
For now there are three unit test cases for testing REST API.
Follow the instructions below in order to run automated tests.

 * Running tests with IDE:
    * Run with any IDE the "RestappApplicationTests.java" file located in project location "spring-rest-app/src/test/com.arianit.restapp/".
 * Running tests with command line:
    * Open the Terminal
    * Change directory to the project directory in terminal
    * Run the command below:
 ```
  sudo mvn test
 ```
