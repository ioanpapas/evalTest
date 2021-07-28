package evalTest;

import com.google.common.math.Stats;

import java.util.Arrays;
import java.util.stream.Stream;


public class StatisticalUtilsArray {
    double[] array;

    StatisticalUtilsArray(){ };

    StatisticalUtilsArray(double[] array){
        this.array=array;
    }

    public double findMinOfArray(){
        double min=Stats.of(array).min();
        //double min= Arrays.stream(array).min().getAsDouble();
        return min;
    }

    public double findMaxOfArray(){
        double max=Stats.of(array).max();
        //double max= Arrays.stream(array).max().getAsDouble();
        return max;
    }

    public double findMeanOfArray(){
        double mean=Stats.of(array).mean();
        //double mean=Arrays.stream(array).average().getAsDouble();
        return mean;
    }

    public double findMedianOfArray(){
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0)
            median = ((double)array[array.length/2] + (double)array[array.length/2 - 1])/2;
        else
            median = (double) array[array.length/2];
        return median;
    }

    public double findStDOfArray(){
        double std=Stats.of(array).populationStandardDeviation();
        return std;
    }

}
