# Software Engineering Evaluation Test
## AscendingMinima Algorithm 

This is the implementation for the AscendingMinima Algorithm. It features 3 classes: 

-StatisticalUtilsArray: Find the minimum, maximum, mean, median, standard deviation for an array of doubles
-StatisticalUtilsArrayList: Find the minimum, maximum, mean, median, standard deviation for an array list of doubles
-AscendingMinima: The implementation of the algorithm. You can find the algorithm [here](http://softwarelearner.blogspot.com/2011/04/minima-in-sliding-window.html)

## Installation

Go to the root of the pom.xml file and type in the command line
```
mvn clean install
```
## Usage of StatisticalUtils
Example:
```
import StatisticalUtilsArray.java
import StatisticalUtilsArrayList.java

#find minimum of array, returns 0
double[] array={0,1,2,3,4,5,6};
double min=StatisticalUtilsArray.findMinOfArray(array);
```



