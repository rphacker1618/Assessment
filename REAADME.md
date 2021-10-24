JabaTalksAutomation
 
1.Created Maven project
2.Used Page Object Model approach 
3.Based on Page object Model approach have created separate package like
    Under src/main/java
    a.config package: which consist of config.porperties files where we can store environment variable
    b.driver package: where we can store drivers for different browser
    c.pages package: object repository for storing locator of each screen
    d.screenshots package: storing all the screenshots if we encounter any failed testcase or issue
    e.testBase package: BaseClass of the entire project
    f.testData package: storing excel sheet for data driven approach
    g.util package: consist of class where we can create some common function/javascript code that can be used across entire project
    Under src/main/resources
    a.log4j.properties : for generating logs
    b.testng.xml : runner file of executing testcases
    Under src/test/java
    a.testcases package: where all testcases related to screen are been written
4.POM.xml file consist of all the dependency that are required for the project


As a part of this assessment have written 3 testcases
1.pageTileTest: validating the tile of the page
2.ValidateDropDownValueTest: validating that the dropdown has "English" and "Dutch"
3.fileFormTest: completing the form

How to Run the Code
1.Import the project into IDE
2.POM.xml will download all the dependency file
3.Open testng.xml file and run it
    