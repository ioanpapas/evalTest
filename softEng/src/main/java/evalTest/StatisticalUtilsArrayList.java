package evalTest;

import com.google.common.math.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StatisticalUtilsArrayList {
    ArrayList<Double> arrayList;

    StatisticalUtilsArrayList(){ };

    StatisticalUtilsArrayList(ArrayList<Double> arrayList){
        this.arrayList=arrayList;
    }

    public void setArrayList(ArrayList<Double> arrayList){
        this.arrayList=arrayList;
    }

    public double findMinOfArrayList(){
        double min= Stats.of(arrayList).min();
        //double min= Arrays.stream(array).min().getAsDouble();
        return min;
    }

    public double findMaxOfArrayList(){
        double max=Stats.of(arrayList).max();
        //double max= Arrays.stream(array).max().getAsDouble();
        return max;
    }

    public double findMeanOfArrayList(){
        double mean=Stats.of(arrayList).mean();
        //double mean=Arrays.stream(array).average().getAsDouble();
        return mean;
    }

    public double findMedianOfArrayList(){
        Collections.sort(arrayList);
        double median;
        if (arrayList.size() % 2 == 0)
            median = ((double)arrayList.get(arrayList.size()/2) + (double)arrayList.get(arrayList.size()/2 - 1))/2;
        else
            median = (double) arrayList.get(arrayList.size()/2);
        return median;
    }

    public double findStDOfArrayList(){
        double std=Stats.of(arrayList).populationStandardDeviation();
        return std;
    }
        }
