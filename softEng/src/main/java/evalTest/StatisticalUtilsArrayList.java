package evalTest;

import com.google.common.math.Stats;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class implements 5 statistical utilities that are needed for an ArrayList of doubles
 * These are: Minimum, Maximum, Median, Mean Value and the Standard Deviation.
 *
 * @author Ioannis Papas
 * @version 2021.1
 * @since 28/07/2021
 *
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
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        //return Stats.of(arrayList).min();
        return arrayList.stream().mapToDouble(v->v).min().orElseThrow(NoSuchElementException::new);
    }

    /**
     * This is a method that finds the maximum value of the array list
     *
     * @param arrayList the arrayList used to find the maximum, with double values
     *
     * @return The maximum value of the array list, as a double value
     */

    public static double findMaxOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }

        //return Stats.of(arrayList).max();
        return arrayList.stream().mapToDouble(v->v).max().orElseThrow(NoSuchElementException::new);
    }

    /**
     * This is a method that finds the mean value of the array list
     *
     * @param arrayList the arrayList used to find the mean, with double values
     *
     * @return The mean value of the arrayList, as a double value
     */

    public static double findMeanOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        //return Stats.of(arrayList).mean();
        return (arrayList.stream().mapToDouble(v->v).sum())/(arrayList.stream().count());
    }

    /**
     * This is a method that finds the median value of the array list
     *
     * @param arrayList the arrayList used to find the median, with double values
     *
     * @return The median value of the List, as a double value
     */

    public static double findMedianOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        List<Double> sorted=arrayList.stream().sorted().collect(Collectors.toList());
        if (sorted.size() % 2 == 0)
            return ((double)sorted.get(sorted.size()/2) + (double)sorted.get(sorted.size()/2 - 1))/2;
        else
            return (double) sorted.get(sorted.size()/2);

        //Collections.sort(arrayList);
        //if (arrayList.size() % 2 == 0)
        //    return ((double)arrayList.get(arrayList.size()/2) + (double)arrayList.get(arrayList.size()/2 - 1))/2;
        //else
        //    return (double) arrayList.get(arrayList.size()/2);
    }

    /**
     * This is a method that finds the standard deviation of the array list
     *
     * @param arrayList the arrayList used to find the standard deviation, with double values
     *
     * @return The standard deviation of the array, as a double value
     */

    public static double findStDOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        //return Stats.of(arrayList).sampleStandardDeviation();

        //find the mean of our data
        double mean=StatisticalUtilsArrayList.findMeanOfArrayList(arrayList);

        //find the variance
        double var=arrayList.stream()
                //(value-mean)^2
                .mapToDouble((v)->Math.pow(v-mean,2.0))
                //all sum
                .sum();
        //return the square root of the variance divided by the number of values -1 which is the standard deviation
        return Math.sqrt(var/(arrayList.size()-1));
    }
}
