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
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

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

    double[] testArray1={1,1,1};
    StatisticalUtilsArray arr1=new StatisticalUtilsArray(testArray1);

    /**
     * @link StatisticalUtilsArray
     */
    @Test
    public void testStatsOfArray2(){
        assertEquals(1,arr1.findMinOfArray(),0.01);
        assertEquals(1,arr1.findMaxOfArray(),0.01);
        assertEquals(1,arr1.findMeanOfArray(),0.01);
        assertEquals(1,arr1.findMedianOfArray(),0.01);
        assertEquals(0,arr1.findStDOfArray(),0.01);
    }

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
