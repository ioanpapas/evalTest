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
 * @param <T> a generic parameter so the class is used for any numerical format (integer,float,double etc.)
 */

public class StatisticalUtilsArrayListGenerics<T extends Number>{

    /**
     * This is a method that finds the minimum value of the array list
     *
     * @param arrayList the arrayList used to find the minimum, with double values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The minimum value of the arrayList, as a double value
     */
    public static <T extends Number> double findMinOfArrayList(ArrayList<T> arrayList){
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
        return arrayList.stream().map(v->v.doubleValue()).mapToDouble(v->v).sum()/arrayList.stream().count();
    }

    /**
     * This is a method that finds the minimum value of the array list
     *
     * @param arrayList the arrayList used to find the minimum, with double values
     * @param <T> a generic parameter so the array list can be of any numerical format
     *
     * @return The minimum value of the arrayList, as a double value
     */
    public static double findMedianOfArrayList(ArrayList<Double> arrayList) {
        if (arrayList.size() == 0) {
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }
        List<Double> sorted = arrayList.stream().sorted().collect(Collectors.toList());
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
    public static double findStDOfArrayList(ArrayList<Double> arrayList){
        if(arrayList.size()==0){
            System.out.println("ArrayList is empty");
            return Double.MIN_VALUE;
        }
        //return Stats.of(arrayList).sampleStandardDeviation();

        //find the mean of our data
        double mean=StatisticalUtilsArrayList.findMeanOfArrayList(arrayList);
        //normalize the data subtracting the mean value
        List<Double> normalized=arrayList.stream().map(value->value-mean).collect(Collectors.toList());
        //find the sample variance by summing up all normalized values squared and divided by the number of samples minus 1
        double var=normalized.stream().map(value->value*value).collect(Collectors.toList()).stream().mapToDouble(v->v).sum()/(normalized.stream().count()-1);
        //return the square root of the variance which is the standard deviation
        return Math.sqrt(var);
    }




}
