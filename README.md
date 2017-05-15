# GIT_Repo_CAFE
CAFE


 Solution design:

- The facade pattern and composite design patterns are used to build the application.



Technical design:
Class diagram

 ![cafexpricer](https://cloud.githubusercontent.com/assets/28501639/26078593/f7315598-39b7-11e7-9b32-ef1cd6325f57.gif)



Build:
- Development Technology stack – Java8, Spring Boot, Spring and Spring data repository
- Test technology stack - Mockito
- Maven is used as a build tool.
- Eclipse Oxygen is used for development tool.
- GIT master branch is used for code repository.

Test:
- Download the source code and navigate to root (demo) directory which has POM.
- Run the Spring boot application with demo profile
- mvn spring-boot:run -Drun.arguments="arg1,arg2"
- (mvn spring-boot:run -Drun.arguments="Steak Sandwich,Cheese Sandwich")
- a. Loads cafe reference data 
- b. Perform the test.
- To run the JUNIT test cases, please run the command below from root directory. Please note that data repositories are mocked to test individual components.
- mvn test 	

