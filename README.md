# About Framework
This framework is based on Cucumber BDD with Java.We have also used Maven, Selenium, Junit Assertion and Apache logger.
Here We are automating our e-commerce site i.e. automationpractice.com and finally generating Cucumber Reports in HTML format.

# instructions to run
Way 1 to Run
* open project in IntelliJ
* go to runner class inside src/test/java/cucumberoption
* right click on Runner class and click on Run "Runner" 

Way 2 to Run
* open cmd
* go to project location
* write mvn test and hit enter

Way 3 to Run
* open project in IDE  like IntelliJ
* go to terminal
* write command mvn test and hit enter

#Note : Execution machine should have java and maven already installed.

#Suggested Enhancement/Other way to do below things
* use of switch case in DriverFactory class in place of if-else
* use of split function in place of substring function in OrderSummayPage class

# Path for Cucumber HTML Report 
go to target folder ---> expand cucumber-html-reports folder and then open overview-features.html file in browser