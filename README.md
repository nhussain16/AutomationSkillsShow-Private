# AutomationSkillsShow-Private
Automation project created using selenium automation tool and BDD scenarios written in cucumber via java.

# Technologies Used:
1.  Selenium WebDriver with Java Language binding
2.  Cucumber 6.x JVM library
3.  JDK 1.8
4.  Maven (Build tool) dependencies
5.  Maven Plugins
6.  Cucumber extent report 6 adapter
7.  JUnit 4.x library
8.  Log4j
9.  GIT HUB - Git Repo
10. Eclipse (IDE)

# Project Components
I have design different components in this Framework:
1. Feature File
2. Step Definition Class
3. Configuration File
4. Cucumber Hooks with before and after scenarios
6. Cucumber 6 Extent Report Adaptor for Spark HTML / PDF Reports
7. Test Runners in JUnit for assertions
8. Page Class for POM
9. Maven with pom.xml with different dependencies and plugins
10. Used Parallel Execution- but currently will not work because I have only 1 feature file
11. Cucumber 6 Web HTML Reports
12. Screenshot for Failure scenarios

# Pre-requisite
      Ensure following plugins installed else follow below methods
      
      [1]Steps to add Eclipse cucumber plugin:
         From Eclipse, go to menu Help then select Install New software
         Work with: <[https://cucumber.github.io/cucumber-eclipse/update-site/]>
         Select the check-box for Cucumber Eclipse Plugin
         Select Next as per the instruction shown during installation.
         Restart your Eclipse after completion of instruction.
      
      [2]Download Maven from <http://maven.apache.org/download.cgi>
        download binray,zip file and extract to your local folder after that set 2 new environement variables
        ( M2_HOME and MAVEN_HOME with following path [C:\Program Files\apache-maven-3.8.1]
        and add following path in path variable [C:\Program Files\apache-maven-3.8.1\bin]
        
      [3]Add junit library from Project
         Click on project Properties-> [Java Build Path]-> Libraries->Add Library->
         select [JUnit] latest version and click on [Apply] button then [Apply & Close] button

# How to use
1.  You can clone this project
2.  open project in eclipse
3.  Access pom.xml file and save it so that it install plugins and dependencies
4.  Run tests as junit Test
5.  you can see the log in console after execution
6.  you can find the log file which show the steps and what value is used - [application.log] created at project root folder
7.  you can find html test execution report from following path in your windows folder structure [..\test-output\SparkReport/Index.html]
8.  Open pdf report from following path [..\test output\PdfReport\ExtentPdf2.pdf] for detailed report and can be shared with stakeholders :)
