package evalTest;

import com.google.common.math.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class implements 5 statistical utilities that are needed for an ArrayList of doubles
 * These are: Minimum, Maximum, Median, Mean Value and the Standard Deviation.
 *
 * @author Ioannis Papas
 * @version 2021.1
 * @since 28/07/2021
 */

public class StatisticalUtilsArrayList {
    /**
     * This is a method that finds the minimum value of the array list
     *
     * @param arrayList the arrayList used to find the minimum, with double values
     *
     * @return The minimum value of the arrayList, as a double value
     */

    public static double findMinOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.size()==0){
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(arrayList).min();
    }

    /**
     * This is a method that finds the maximum value of the array list
     *
     * @param arrayList the arrayList used to find the maximum, with double values
     *
     * @return The maximum value of the array list, as a double value
     */

    public static double findMaxOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.size()==0){
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }

        return Stats.of(arrayList).max();
    }

    /**
     * This is a method that finds the mean value of the array list
     *
     * @param arrayList the arrayList used to find the mean, with double values
     *
     * @return The mean value of the arrayList, as a double value
     */

    public static double findMeanOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.size()==0){
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(arrayList).mean();
    }

    /**
     * This is a method that finds the median value of the array list
     *
     * @param arrayList the arrayList used to find the median, with double values
     *
     * @return The median value of the List, as a double value
     */

    public static double findMedianOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.size()==0){
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }
        Collections.sort(arrayList);
        double median;
        if (arrayList.size() % 2 == 0)
            return ((double)arrayList.get(arrayList.size()/2) + (double)arrayList.get(arrayList.size()/2 - 1))/2;
        else
            return (double) arrayList.get(arrayList.size()/2);
    }

    /**
     * This is a method that finds the standard deviation of the array list
     *
     * @param arrayList the arrayList used to find the standard deviation, with double values
     *
     * @return The standard deviation of the array, as a double value
     */

    public static double findStDOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.size()==0){
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }
        return Stats.of(arrayList).sampleStandardDeviation();
    }
}
