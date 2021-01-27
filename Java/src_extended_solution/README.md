# Andre Weber's extended solution for the refactoring of Kata example.
## Description of this solution
After having implemented a solution I presume conform to the expectations, I have tried to create a version where the choices to apply different rules in the method "updateQuality()" doesn't depend anymore of the name of the item.
To obtain such result, I have created a new class named "ParametrizedItem" (class extending "Item") where the special rules are stored in the definition of the item.   
## Instructions to compile the solution
1. If not already done, add the path to the java SDK in the PATH variable
     set path=%path%;C:\Program Files\Java\jdk1.8.0_161\bin
1. Go to the "root" directory of our solution
      for example,
         >cd C:\javaEclipseWorkSpaces\GildedRose-Refactoring-Kata\Java
1.  Launch javac with the necessary arguments : path of source files, path of libraries (currently we only use JUnit 4)
       for example,
          >javac -d bin -cp "lib/junit4/*" -sourcepath "src_exended_solution/main/java;src_extended_solution/test/java" ./src_extended_solution/main/java/com/gildedrose/*.java ./src_extended_solution/test/java/com/gildedrose/*.java 
      

## Instructions to execute the solution
### To execute the TexttestFixture
         >java -cp bin com.gildedrose/TexttestFixture
         