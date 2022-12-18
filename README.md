BradyTechTest
Automated using selenium Webdriver, Java and cucumber framework.

Important files to look for in the source code folder structure:
•	Runner file to run the required tests using tags can be found here:
/BradyTechTest/src/test/java/cucumberTests/TestRunner.java

•	Cucumber feature file containing the task scenario can be found here:
/BradyTechTest/features/TradingViewTest.feature

•	The code written to implement/automate the steps can be found here:
/BradyTechTest/src/test/java/stepDefinition/TradingViewSteps.java

•	PageObjects can be found here:
/BradyTechTest/src/main/java/PageObjects


To run the source code in your local machine please follow below steps:
1.	Install Java and Maven
2.	Install eclipse IDE or other similar IDEs of your choice.
3.	I have used eclipse IDE in my machine and have installed cucumber eclipse plugin from eclipse market place:
4.	Download or pull the source code from the git hub.
5.	Right-click on the project and select Run AS -> Maven clean. Once the build is successful, right click on the project again and selet Run AS - > Maven test.
	Alternatively, you can use cmd prompt > navigate to the project folder and run ‘mvn clean’ and ‘mvn test’ commands.
