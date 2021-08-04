package evalTest;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


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
    public void statisticalUtilsArrayTest(){
        Assertions.assertEquals(1, StatisticalUtilsArray.findMinOfArray(testArray),0.01);
        Assertions.assertEquals(20,StatisticalUtilsArray.findMaxOfArray(testArray),0.01);
        Assertions.assertEquals((double)76/9,StatisticalUtilsArray.findMeanOfArray(testArray),0.01);
        Assertions.assertEquals(8,StatisticalUtilsArray.findMedianOfArray(testArray),0.01);
        Assertions.assertEquals(6.4829,StatisticalUtilsArray.findStDOfArray(testArray),0.01);
    }

    /**
     * Test for the statistical utils for an array, if the array is empty
     *
     * @link StatisticalUtilsArray Class
     */
    double[] emptyArray={};
    @Test
    public void statisticalUtilsEmptyArrayTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArray.findMinOfArray(emptyArray);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArray.findMaxOfArray(emptyArray);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArray.findMeanOfArray(emptyArray);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArray.findMedianOfArray(emptyArray);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArray.findStDOfArray(emptyArray);
        });
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
    public void StatisticalUtilsArrayListTest(){
        Assertions.assertEquals(1, StatisticalUtilsArrayList.findMinOfArrayList(testArrayList),0.01);
        Assertions.assertEquals(20, StatisticalUtilsArrayList.findMaxOfArrayList(testArrayList),0.01);
        Assertions.assertEquals((double)76/9, StatisticalUtilsArrayList.findMeanOfArrayList(testArrayList),0.01);
        Assertions.assertEquals(8, StatisticalUtilsArrayList.findMedianOfArrayList(testArrayList),0.01);
        Assertions.assertEquals(6.4829, StatisticalUtilsArrayList.findStDOfArrayList(testArrayList),0.01);
    }

    /**
     * Test for the statistical utils for an arraylist if arrayList is empty
     *
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Double> emptyArrayList=new ArrayList<Double>();
    @Test
    public void StatisticalUtilsEmptyArrayListTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayList.findMinOfArrayList(emptyArrayList);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayList.findMaxOfArrayList(emptyArrayList);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayList.findMeanOfArrayList(emptyArrayList);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayList.findMedianOfArrayList(emptyArrayList);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayList.findStDOfArrayList(emptyArrayList);
        });
    }

    /**
     * Test for the statistical utils for an arraylist using the generics class
     *
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Integer> testArrayListGenerics=new ArrayList<>(){
        {
            add(3);
            add(5);
            add(2);
            add(8);
            add(9);
            add(13);
            add(20);
            add(1);
            add(15);
        }
    };
    @Test
    public void StatisticalUtilsArrayListGenericsTest(){
        Assertions.assertEquals(1, StatisticalUtilsArrayListGenerics.findMinOfArrayList(testArrayListGenerics),0.01);
        Assertions.assertEquals(20, StatisticalUtilsArrayListGenerics.findMaxOfArrayList(testArrayListGenerics),0.01);
        Assertions.assertEquals((double)76/9, StatisticalUtilsArrayListGenerics.findMeanOfArrayList(testArrayListGenerics),0.01);
        Assertions.assertEquals(8, StatisticalUtilsArrayListGenerics.findMedianOfArrayList(testArrayListGenerics),0.01);
        Assertions.assertEquals(6.4829, StatisticalUtilsArrayListGenerics.findStDOfArrayList(testArrayListGenerics),0.01);
    }

    /**
     * Test for the statistical utils for an arraylist if arrayList is empty using the generics class
     *
     * @link StatisticalUtilsArrayList Class
     */
    ArrayList<Float> emptyArrayListGenerics=new ArrayList<>();
    @Test
    public void StatisticalUtilsEmptyArrayListGenericsTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayListGenerics.findMinOfArrayList(emptyArrayListGenerics);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayListGenerics.findMaxOfArrayList(emptyArrayListGenerics);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayListGenerics.findMeanOfArrayList(emptyArrayListGenerics);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayListGenerics.findMedianOfArrayList(emptyArrayListGenerics);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            StatisticalUtilsArrayListGenerics.findStDOfArrayList(emptyArrayListGenerics);
        });
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
    public void ascendingMinimaTest(){
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Test for the Ascending Minima when the windows size is greater than the arrayList size
     *
     * @link AscendingMinima Class
     */
    ArrayList<Double> arrayListOneItem=new ArrayList<Double>(){
        {
            add((double)1);
        }
    };
    int windows_size2=3;

    @Test
    public void ascendingMinimaGreaterWindowSizeTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            AscendingMinima ascMin=new AscendingMinima(windows_size2,arrayListOneItem);
        });
    }

    /**
     * A test for the ascending minima class when we have an empty array list
     *
     * @link AscendingMinima Class
     *
     */
    ArrayList<Double> emptyArrayListAscMin=new ArrayList<>();
    int windowEmptySize=1;

    @Test
    public void ascendingMinimaEmptyArrayListTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            AscendingMinima ascMin=new AscendingMinima(windowEmptySize,emptyArrayListAscMin);
        });
    }

    /**
     * A test for the ascending minima class when we give a negative window size
     *
     * @link AscendingMinima Class
     */
    int negativeWindowSize=-3;

    @Test
    public void ascendingMinimaNegativeWindowSizeTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            AscendingMinima ascMin=new AscendingMinima(negativeWindowSize,arrayList);
        });
    }



}
