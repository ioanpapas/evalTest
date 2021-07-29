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
     * This variable represents the ArrayList used for getting the statistics
     */
    ArrayList<Double> arrayList;

    /**
     * This is the void constructor method of the class, used for initialization
     */
    StatisticalUtilsArrayList(){ };

    /**
     * This is the main constructor method of the class, used for initialization
     *
     * @param arrayList The arrayList to be used for finding the stats
     */

    StatisticalUtilsArrayList(ArrayList<Double> arrayList){
        this.arrayList=arrayList;
    }

    /**
     * This is the setter method for the arrayList to be used for finding the stats
     *
     * @param arrayList The arrayList to be used for finding the stats, as an double ArrayList
     */
    public void setArrayList(ArrayList<Double> arrayList){
        this.arrayList=arrayList;
    }

    /**
     * This is the getter method for the arrayList to be used for finding the stats
     *
     * @return The arrayList to be used for finding the stats, as an double ArrayList
     */
    public ArrayList<Double> getArrayList(){
        return arrayList;
    }

    /**
     * This is a method that finds the minimum value of the array list
     *
     * @return The minimum value of the arrayList, as a double value
     */
    public double findMinOfArrayList(){
        if(arrayList.size()==0){
            return Double.MIN_VALUE;
        }
        double min= Stats.of(arrayList).min();
        return min;
    }

    /**
     * This is a method that finds the maximum value of the array list
     *
     * @return The maximum value of the array list, as a double value
     */
    public double findMaxOfArrayList(){
        if(arrayList.size()==0){
            return Double.MIN_VALUE;
        }
        double max=Stats.of(arrayList).max();
        return max;
    }

    /**
     * This is a method that finds the mean value of the array list
     *
     * @return The mean value of the arrayList, as a double value
     */
    public double findMeanOfArrayList(){
        if(arrayList.size()==0){
            return Double.MIN_VALUE;
        }
        double mean=Stats.of(arrayList).mean();
        return mean;
    }

    /**
     * This is a method that finds the median value of the array list
     *
     * @return The median value of the List, as a double value
     */
    public double findMedianOfArrayList(){
        if(arrayList.size()==0){
            return Double.MIN_VALUE;
        }
        Collections.sort(arrayList);
        double median;
        if (arrayList.size() % 2 == 0)
            median = ((double)arrayList.get(arrayList.size()/2) + (double)arrayList.get(arrayList.size()/2 - 1))/2;
        else
            median = (double) arrayList.get(arrayList.size()/2);
        return median;
    }

    /**
     * This is a method that finds the standard deviation of the array list
     *
     * @return The standard deviation of the array, as a double value
     */
    public double findStDOfArrayList(){
        if(arrayList.size()==0){
            return Double.MIN_VALUE;
        }
        double std=Stats.of(arrayList).sampleStandardDeviation();
        return std;
    }
}
