package evalTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test for the statistical utils for an array
     *
     * @link StatisticalUtilsArray Class
     */
    double[] testArray={3,5,2,8,9,13,20,1,15};
    @Test
    public void testStatsOfArray1(){
        assertEquals(1, StatisticalUtilsArray.findMinOfArray(testArray),0.01);
        assertEquals(20,StatisticalUtilsArray.findMaxOfArray(testArray),0.01);
        assertEquals((double)76/9,StatisticalUtilsArray.findMeanOfArray(testArray),0.01);
        assertEquals(8,StatisticalUtilsArray.findMedianOfArray(testArray),0.01);
        assertEquals(6.4829,StatisticalUtilsArray.findStDOfArray(testArray),0.01);
    }

    /**
     * Test for the statistical utils for an array
     *
     * @link StatisticalUtilsArray Class
     */
    double[] testArray1={1,1,1};
    @Test
    public void testStatsOfArray2(){
        assertEquals(1,StatisticalUtilsArray.findMinOfArray(testArray1),0.01);
        assertEquals(1,StatisticalUtilsArray.findMaxOfArray(testArray1),0.01);
        assertEquals(1,StatisticalUtilsArray.findMeanOfArray(testArray1),0.01);
        assertEquals(1,StatisticalUtilsArray.findMedianOfArray(testArray1),0.01);
        assertEquals(0,StatisticalUtilsArray.findStDOfArray(testArray1),0.01);
    }

    /**
     * Test for the statistical utils for an array, if the array is empty
     *
     * @link StatisticalUtilsArray Class
     */
    double[] testArray2={};
    @Test
    public void testStatsOfArray3(){
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArray.findMinOfArray(testArray2),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArray.findMaxOfArray(testArray2),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArray.findMeanOfArray(testArray2),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArray.findMedianOfArray(testArray2),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArray.findStDOfArray(testArray2),0.01);
    }

    /**
     * Test for the statistical utils for an arraylist
     *
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
    @Test
    public void testStatsOfArrayList1(){
        assertEquals(1, StatisticalUtilsArrayList.findMinOfArrayList(testArrayList),0.01);
        assertEquals(20, StatisticalUtilsArrayList.findMaxOfArrayList(testArrayList),0.01);
        assertEquals((double)76/9, StatisticalUtilsArrayList.findMeanOfArrayList(testArrayList),0.01);
        assertEquals(8, StatisticalUtilsArrayList.findMedianOfArrayList(testArrayList),0.01);
        assertEquals(6.4829, StatisticalUtilsArrayList.findStDOfArrayList(testArrayList),0.01);
    }
    /**
     * Test for the statistical utils for an arraylist
     *
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Double> testArrayList2=new ArrayList<Double>(){
        {
            add((double)1);
            add((double)1);
            add((double)1);
        }
    };
    @Test
    public void testStatsOfArrayList2(){
        assertEquals(1, StatisticalUtilsArrayList.findMinOfArrayList(testArrayList2),0.01);
        assertEquals(1, StatisticalUtilsArrayList.findMaxOfArrayList(testArrayList2),0.01);
        assertEquals(1, StatisticalUtilsArrayList.findMeanOfArrayList(testArrayList2),0.01);
        assertEquals(1, StatisticalUtilsArrayList.findMedianOfArrayList(testArrayList2),0.01);
        assertEquals(0, StatisticalUtilsArrayList.findStDOfArrayList(testArrayList2),0.01);
    }

    /**
     * Test for the statistical utils for an arraylist if arrayList is empty
     *
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Double> testArrayList3=new ArrayList<Double>();
    @Test
    public void testStatsOfArrayList3(){
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArrayList.findMinOfArrayList(testArrayList3),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArrayList.findMaxOfArrayList(testArrayList3),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArrayList.findMeanOfArrayList(testArrayList3),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArrayList.findMedianOfArrayList(testArrayList3),0.01);
        assertEquals(Double.MIN_VALUE,StatisticalUtilsArrayList.findStDOfArrayList(testArrayList3),0.01);
    }
    /**
     * Test for the Ascending Minima
     *
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
    AscendingMinima ascMin=new AscendingMinima(windows_size,arrayList);
    Double[] actual=ascMin.findAscendingMinima().toArray(new Double[arrayList.size()-windows_size+1]);
    Double[] expected={(double)1,(double)1,(double)2,(double)2,(double)4,(double)4};
    @Test
    public void testAscendingMinima(){
        assertArrayEquals(expected, actual);
    }

    /**
     * Test for the Ascending Minima when the windows size is bigger than the arrayList size
     *
     * @link AscendingMinima Class
     */
    ArrayList<Double> arrayList2=new ArrayList<Double>(){
        {
            add((double)1);
        }
    };
    int windows_size2=3;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void checkIfExceptionIsThrown(){
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("");
        AscendingMinima ascMin2=new AscendingMinima(windows_size2,arrayList2);
    }

}
