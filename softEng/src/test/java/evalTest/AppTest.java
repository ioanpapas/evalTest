package evalTest;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test for the statistical utils for an array
     * @link StatisticalUtilsArray Class
     */
    double[] testArray={3,5,2,8,9,13,20,1,15};
    StatisticalUtilsArray arr=new StatisticalUtilsArray(testArray);
    @Test
    public void testStatsOfArray1(){
        assertEquals(1, arr.findMinOfArray(),0.01);
        assertEquals(20,arr.findMaxOfArray(),0.01);
        assertEquals((double)76/9,arr.findMeanOfArray(),0.01);
        assertEquals(8,arr.findMedianOfArray(),0.01);
        assertEquals(6.4829,arr.findStDOfArray(),0.01);
    }

    /**
     * Test for the statistical utils for an array
     * @link StatisticalUtilsArray Class
     */
    double[] testArray1={1,1,1};
    StatisticalUtilsArray arr1=new StatisticalUtilsArray(testArray1);
    @Test
    public void testStatsOfArray2(){
        assertEquals(1,arr1.findMinOfArray(),0.01);
        assertEquals(1,arr1.findMaxOfArray(),0.01);
        assertEquals(1,arr1.findMeanOfArray(),0.01);
        assertEquals(1,arr1.findMedianOfArray(),0.01);
        assertEquals(0,arr1.findStDOfArray(),0.01);
    }

    /**
     * Test for the statistical utils for an array, if the array is empty
     * @link StatisticalUtilsArray Class
     */
    double[] testArray2={};
    StatisticalUtilsArray arr2=new StatisticalUtilsArray(testArray2);
    @Test
    public void testStatsOfArray3(){
        assertEquals(Double.MIN_VALUE,arr2.findMinOfArray(),0.01);
        assertEquals(Double.MIN_VALUE,arr2.findMaxOfArray(),0.01);
        assertEquals(Double.MIN_VALUE,arr2.findMeanOfArray(),0.01);
        assertEquals(Double.MIN_VALUE,arr2.findMedianOfArray(),0.01);
        assertEquals(Double.MIN_VALUE,arr2.findStDOfArray(),0.01);
    }

    /**
     * Test for the statistical utils for an arraylist
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Double> testArrayList=new ArrayList<Double>(){
        {
            add((double)3);
            add((double)5);
            add((double)2);
            add((double)8);
            add((double)9);
            add((double)13);
            add((double)20);
            add((double)1);
            add((double)15);
        }
    };
    StatisticalUtilsArrayList arrList=new StatisticalUtilsArrayList(testArrayList);
    @Test
    public void testStatsOfArrayList1(){
        assertEquals(1, arrList.findMinOfArrayList(),0.01);
        assertEquals(20,arrList.findMaxOfArrayList(),0.01);
        assertEquals((double)76/9,arrList.findMeanOfArrayList(),0.01);
        assertEquals(8,arrList.findMedianOfArrayList(),0.01);
        assertEquals(6.4829,arrList.findStDOfArrayList(),0.01);
    }
    /**
     * Test for the statistical utils for an arraylist
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Double> testArrayList2=new ArrayList<Double>(){
        {
            add((double)1);
            add((double)1);
            add((double)1);
        }
    };
    StatisticalUtilsArrayList arrList2=new StatisticalUtilsArrayList(testArrayList2);
    @Test
    public void testStatsOfArrayList2(){
        assertEquals(1, arrList2.findMinOfArrayList(),0.01);
        assertEquals(1,arrList2.findMaxOfArrayList(),0.01);
        assertEquals(1,arrList2.findMeanOfArrayList(),0.01);
        assertEquals(1,arrList2.findMedianOfArrayList(),0.01);
        assertEquals(0,arrList2.findStDOfArrayList(),0.01);
    }

    /**
     * Test for the statistical utils for an arraylist if arrayList is empty
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Double> testArrayList3=new ArrayList<Double>();
    StatisticalUtilsArrayList arrList3=new StatisticalUtilsArrayList(testArrayList3);
    @Test
    public void testStatsOfArrayList3(){
        assertEquals(Double.MIN_VALUE, arrList3.findMinOfArrayList(),0.01);
        assertEquals(Double.MIN_VALUE,arrList3.findMaxOfArrayList(),0.01);
        assertEquals(Double.MIN_VALUE,arrList3.findMeanOfArrayList(),0.01);
        assertEquals(Double.MIN_VALUE,arrList3.findMedianOfArrayList(),0.01);
        assertEquals(Double.MIN_VALUE,arrList3.findStDOfArrayList(),0.01);
    }
    /**
     * Test for the Ascending Minima
     * @link AscendingMinima Class
     */
    ArrayList<Double> arrayList=new ArrayList<Double>(){
        {
            add((double)5);
            add((double)1);
            add((double)3);
            add((double)2);
            add((double)6);
            add((double)8);
            add((double)4);
            add((double)6);
        }
    };
    int windows_size=3;
    AscendingMinima ascMin=new AscendingMinima(windows_size, arrayList.size(),arrayList);
    Double[] actual=ascMin.findAscendingMinima().toArray(new Double[arrayList.size()-windows_size+1]);
    Double[] expected={(double)1,(double)1,(double)2,(double)2,(double)4,(double)4};
    @Test
    public void testAscendingMinima(){
        assertArrayEquals(actual, expected);
    }






    
}
