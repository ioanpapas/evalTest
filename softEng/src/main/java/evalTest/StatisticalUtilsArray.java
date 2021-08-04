package evalTest;

import com.google.common.math.Stats;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
     * @return The minimum value of the array, as a double value
     */
    public static double findMinOfArray(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array...");
        }
        return Stats.of(array).min();
        //return Arrays.stream(array).min().getAsDouble();
    }

    /**
     * This is a method that finds the maximum value of the array
     *
     * @param array the array used to find the maximum, with double values
     * @return The maximum value of the array, as a double value
     */
    public static double findMaxOfArray(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array...");
        }
        //return Stats.of(array).max();
        return Arrays.stream(array).max().getAsDouble();
    }

    /**
     * This is a method that finds the mean value of the array
     *
     * @param array the array used to find the mean, with double values
     * @return The mean value of the array, as a double value
     */
    public static double findMeanOfArray(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array...");
        }
        //return Stats.of(array).mean();
        return Arrays.stream(array).average().getAsDouble();
    }

    /**
     * This is a method that finds the median value of the array
     *
     * @param array the array used to find the median, with double values
     * @return The median value of the array, as a double value
     */
    public static double findMedianOfArray(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array...");
        }
        Arrays.sort(array);

        if (array.length % 2 == 0)
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else
            return array[array.length / 2];
    }

    /**
     * This is a method that finds the standard deviation of the array
     *
     * @param array the array used to find the standard deviation, with double values
     * @return The standard deviation of the arrayList, as a double value
     */
    public static double findStDOfArray(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array...");
        }

        //find the mean of our data
        double mean = StatisticalUtilsArray.findMeanOfArray(array);

        //normalize the data subtracting the mean value
        double[] normalized = Arrays.stream(array).map(value -> value - mean).toArray();

        //find the sample variance by summing up all normalized values squared and divided by the number of samples minus 1
        double var = Arrays.stream(Arrays.stream(normalized).map(value -> value * value).toArray()).sum() / (Arrays.stream(normalized).count() - 1);

        //return the square root of the variance which is the standard deviation
        return Math.sqrt(var);

        //return Stats.of(array).sampleStandardDeviation();
    }
}
