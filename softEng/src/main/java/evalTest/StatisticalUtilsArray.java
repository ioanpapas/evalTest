package evalTest;

import com.google.common.math.Stats;


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
     * This is a method that finds the minimum value of the array
     *
     * @param array the array used to find the minimum, with double values
     *
     * @return The minimum value of the array, as a double value
     */
    public static double findMinOfArray(double[] array){
        if (array.length==0){
            System.out.println("Array is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(array).min();
        //double min= Arrays.stream(array).min().getAsDouble();
    }

    /**
     * This is a method that finds the maximum value of the array
     *
     * @param array the array used to find the maximum, with double values
     *
     * @return The maximum value of the array, as a double value
     */
    public static double findMaxOfArray(double[] array){
        if (array.length==0){
            System.out.println("Array is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(array).max();
        //double max= Arrays.stream(array).max().getAsDouble();
    }

    /**
     * This is a method that finds the mean value of the array
     *
     * @param array the array used to find the mean, with double values
     *
     * @return The mean value of the array, as a double value
     */
    public static double findMeanOfArray(double[] array){
        if (array.length==0){
            System.out.println("Array is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(array).mean();
        //double mean=Arrays.stream(array).average().getAsDouble();
    }

    /**
     * This is a method that finds the median value of the array
     *
     * @param array the array used to find the median, with double values
     *
     * @return The median value of the array, as a double value
     */
    public static double findMedianOfArray(double[] array){
        if (array.length==0){
            System.out.println("Array is empty");
            return Double.MIN_VALUE;
        }
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0)
            return (array[array.length/2] + array[array.length/2 - 1])/2;
        else
            return array[array.length/2];
    }

    /**
     * This is a method that finds the standard deviation of the array
     *
     * @param array the array used to find the standard deviation, with double values
     *
     * @return The standard deviation of the arrayList, as a double value
     */
    public static double findStDOfArray(double[] array){
        if (array.length==0){
            System.out.println("Array is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(array).sampleStandardDeviation();
    }

}
