package evalTest;

import com.google.common.math.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This class implements 5 statistical utilities that are needed for an Array of double values
 * These are: Minimum, Maximum, Median, Mean Value and the Standard Deviation.
 *
 * @author Ioannis Papas
 * @version 2021.1
 * @since 28/07/2021
 */


public class StatisticalUtilsArray {
    /**
     * This variable represents the array used for getting the statistics
     */
    double[] array;

    /**
     * This is the void constructor method of the class, used for initialization
     */
    StatisticalUtilsArray(){ };

    /**
     * This is the main constructor method of the class, used for initialization
     *
     * @param array The array to be used for finding the stats
     */
    StatisticalUtilsArray(double[] array){
        this.array=array;
    }

    /**
     * This is the setter method for the array to be used for finding the stats
     *
     * @param array The array to be used for finding the stats, as an double array
     */
    public void setArrayList(double[] array){
        this.array=array;
    }

    /**
     * This is the getter method for the array to be used for finding the stats
     *
     * @return The array to be used for finding the stats, as an double Array
     */
    public double[] getArrayList(){
        return array;
    }

    /**
     * This is a method that finds the minimum value of the array
     *
     * @return The minimum value of the array, as a double value
     */
    public double findMinOfArray(){
        double min=Stats.of(array).min();
        //double min= Arrays.stream(array).min().getAsDouble();
        return min;
    }

    /**
     * This is a method that finds the maximum value of the array
     *
     * @return The maximum value of the array, as a double value
     */
    public double findMaxOfArray(){
        double max=Stats.of(array).max();
        //double max= Arrays.stream(array).max().getAsDouble();
        return max;
    }

    /**
     * This is a method that finds the mean value of the array
     *
     * @return The mean value of the array, as a double value
     */
    public double findMeanOfArray(){
        double mean=Stats.of(array).mean();
        //double mean=Arrays.stream(array).average().getAsDouble();
        return mean;
    }

    /**
     * This is a method that finds the median value of the array
     *
     * @return The median value of the array, as a double value
     */
    public double findMedianOfArray(){
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0)
            median = (array[array.length/2] + array[array.length/2 - 1])/2;
        else
            median = array[array.length/2];
        return median;
    }

    /**
     * This is a method that finds the standard deviation of the array
     *
     * @return The standard deviation of the arrayList, as a double value
     */
    public double findStDOfArray(){
        double std=Stats.of(array).sampleStandardDeviation();
        return std;
    }

}
