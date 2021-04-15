# About Framework
This framework has been created using Cucumber BDD,Java,Maven,Selenium and Junit to automate http://automationpractice.com/index.php site.

#List of libraries:
Java, Selenium, Cucumber, Maven and Junit

#Environment required for Execution:
1. Java 1.8 in your machine
2. Maven in your machine

GitHub Location: https://www.github.com/puneet8085/cucumberassignment

#Steps for execution: 
First, Clone project from mentioned GitHub location into your local machine

#Way 1 : executing through maven command from command line
1. Open command prompt and navigate to project location
2. Write "mvn test" and hit enter in order to execute with default browser mentioned in default properties file
3. Write "mvn clean" and hit enter in order to clean the previous reports

#Way 2: executing through IDE
1. Open the project in Intellij/Eclipse
2. Run feature files present in Feature folder under src/test/resources
3. Run "Runner" file present in cucumberoption package under src/test/java

# Path for Cucumber HTML Report
Open target folder ---> Open cucumber-html-reports folder --> Open cucumber-reports.html file in browser

#Improvements/Suggestion:
Like any other framework this framework too has the scope of improvements. 
Most of these has been skipped due to time constraints
1. Data Can be driven from Excel file
2. Creation of utility to fetch data from database
3. Integration of damianszczepanik/allure/extent report.
4. Creation of CI/CD pipeline using TeamCity/Jenkins.