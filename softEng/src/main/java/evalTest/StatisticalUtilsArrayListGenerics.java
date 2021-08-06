package evalTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class implements 5 statistical utilities that are needed for an ArrayList of parameter T
 * These are: Minimum, Maximum, Median, Mean Value and the Standard Deviation.
 *
 * @author Ioannis Papas
 * @version 2021.1
 * @since 02/08/2021
 *
 */

public class StatisticalUtilsArrayListGenerics{

    /**
     * This is a method that finds the minimum value of the array list
     *
     * @param arrayList the arrayList used to find the minimum, with double values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The minimum value of the arrayList, as a double value
     */
    public static <T extends Number> double findMinOfArrayList(ArrayList<T> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }

        return arrayList.stream().map(v->v.doubleValue()).min(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
    }

    /**
     * This is a method that finds the maximum value of the array list
     *
     * @param arrayList the arrayList used to find the maximum, with double values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The maximum value of the arrayList, as a double value
     */
    public static <T extends Number> double findMaxOfArrayList(ArrayList<T> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        return arrayList.stream().map(v->v.doubleValue()).max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
    }

    /**
     * This is a method that finds the mean value of the array list
     *
     * @param arrayList the arrayList used to find the mean, with T values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The maximum value of the arrayList, as a double value
     */
    public static <T extends Number> double findMeanOfArrayList(ArrayList<T> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        return arrayList.stream().map(v->v.doubleValue()).mapToDouble(v->v).average().getAsDouble();
    }

    /**
     * This is a method that finds the minimum value of the array list
     *
     * @param arrayList the arrayList used to find the minimum, with double values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The minimum value of the arrayList, as a double value
     */
    public static <T extends Number> double findMedianOfArrayList(ArrayList<T> arrayList) {
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }
        List<Double> sorted = arrayList.stream().map(v->v.doubleValue()).sorted().collect(Collectors.toList());
        if (sorted.size() % 2 == 0)
            return ((double) sorted.get(sorted.size() / 2) + (double) sorted.get(sorted.size() / 2 - 1)) / 2;
        else
            return (double) sorted.get(sorted.size() / 2);
    }

    /**
     * This is a method that finds the minimum value of the array list
     *
     * @param arrayList the arrayList used to find the minimum, with double values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The minimum value of the arrayList, as a double value
     */
    public static <T extends Number> double findStDOfArrayList(ArrayList<T> arrayList){
        if(arrayList.isEmpty()){
            throw new IllegalArgumentException("Empty array...");
        }

        //find the mean of our data
        double mean=StatisticalUtilsArrayListGenerics.findMeanOfArrayList(arrayList);

        //find the variance
        double var=arrayList.stream()
                //change T values to double
                .map(v->v.doubleValue())
                //(value-mean)^2
                .mapToDouble((v)->Math.pow(v-mean,2.0))
                //all sum
                .sum();
        
        //return the square root of the variance divided by the number of values -1 which is the standard deviation
        return Math.sqrt(var/(arrayList.size()-1));
    }

}
