FeeCalculatorApp is the main class.

To run in IDE -

Intellij
1. Navigate to the project folder using Terminal/CMD
2. mvn idea:idea command will generate the intellij specefic files.
3. Import the project in intellij

Eclipse
1. Navigate to the project folder using Terminal/CMD
2. mvn eclipse:eclipse command will generate the eclipse specefic files.
3. Import the project in eclipse


Maven commands to compile, run test classes and create code coverage report
1. mvn clean compile will compile the source code
2. mvn verify will run all the test classes and generate the code coverage reports inside target/code-coverage folder