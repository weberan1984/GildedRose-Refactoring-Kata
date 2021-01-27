# Andre Weber's solution for the refactoring of Kata example.
## Description of the steps done to obtain this solution
1. I have first adapted the solution to be able to develop in my environment.  I have replaced the usage of junit 5 by junit 4 because I do not yet know the version 5 and I think it doesn't really matter here (it's not the target of this exercise to learn junit 5).
1.  I have added the business rules into comments in the code and I have added unit-tests to cover all such rules.  
## Instructions to compile the solution
1. If not already done, add the path to the java SDK in the PATH variable
     set path=%path%;C:\Program Files\Java\jdk1.8.0_161\bin
1. Go to the "root" directory of our solution
      for example,
         >cd C:\javaEclipseWorkSpaces\GildedRose-Refactoring-Kata\Java
1.  Launch javac with the necessary arguments : path of source files, path of libraries (currently we only use JUnit 4)
       for example,
          >javac -d bin -cp "lib/junit4/*" -sourcepath "src/main/java;src/test/java" ./src/main/java/com/gildedrose/*.java ./src/test/java/com/gildedrose/*.java       

## Instructions to execute the solution
### To execute the TexttestFixture
         >java -cp bin com.gildedrose/TexttestFixture
         