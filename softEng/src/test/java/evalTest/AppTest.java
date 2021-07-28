package evalTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
    @Test
    public void testStatsOfArray2(){
        assertEquals(1,arr1.findMinOfArray(),0.01);
        assertEquals(1,arr1.findMaxOfArray(),0.01);
        assertEquals(1,arr1.findMeanOfArray(),0.01);
        assertEquals(1,arr1.findMedianOfArray(),0.01);
        assertEquals(0,arr1.findStDOfArray(),0.01);
    }

    
}
