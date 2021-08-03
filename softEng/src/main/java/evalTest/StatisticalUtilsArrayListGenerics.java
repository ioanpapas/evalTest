package evalTest;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticalUtilsArrayListGenerics<T extends Number>{

    public static <T extends Number> double findMinOfArrayList(ArrayList<T> arrayList){
        return arrayList.stream().map(v->v.doubleValue()).min(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
    }

    public static <T extends Number> double findMaxOfArrayList(ArrayList<T> arrayList){
        return arrayList.stream().map(v->v.doubleValue()).max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
    }

    public static <T extends Number> double findMeanOfArrayList(ArrayList<T> arrayList){
        return arrayList.stream().map(v->v.doubleValue()).mapToDouble(v->v).sum()/arrayList.stream().count();
    }

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
