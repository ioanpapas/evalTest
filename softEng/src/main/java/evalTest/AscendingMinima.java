package evalTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements the ascendingMinima algorithm. Given a windows size(assume k) and an array, the algorithm first
 * boxes the first k elements of the array and finds the minimum. The minimum is put in a list. After that it discards
 * the first element of the window and it adds the first element of the array that was not in the window. It iterates
 * and finds all the minimum values of each consecutive window and puts them in the list.
 *
 * @author Ioannis Papas
 * @version 2021.1
 * @since 28/07/2021
 */

public class AscendingMinima {
    /**
     * This variable represents the windows size
     */
    int WINDOWS_SIZE;
    /**
     * This variable represents the array size
     */
    int ARRAY_SIZE;
    /**
     * This variable represents the array to be used
     */
    ArrayList<Double> arrayList;

    /**
     * This is the void constructor method of the class, used for initialization
     */
    AscendingMinima(){};

    /**
     * This is the main constructor method of the class, used for initialization
     *
     * @param ws The window size
     * @param as The array size
     * @param arrayList The array to be used
     */
    AscendingMinima(int ws, int as, ArrayList<Double> arrayList){
        this.WINDOWS_SIZE=ws;
        this.ARRAY_SIZE=as;
        this.arrayList=arrayList;
    }

    /**
     * The implementation of the algorithm. While the window is not out of bounds, the algorithm finds the minimum value
     * of the sublist created from the indexes and adds it to a Linked List
     *
     * @return a Linked List containing all the minimum values found for each window
     */
    public Queue<Double> findAscendingMinima() {
        Queue<Double> ascMin=new LinkedList<Double>();
        if (WINDOWS_SIZE>ARRAY_SIZE){
            System.out.println("Windows size is bigger than the array size");
            return ascMin;
        }
        StatisticalUtilsArrayList sublist=new StatisticalUtilsArrayList();
        double minPerWindow;
        for(int i=0;i<ARRAY_SIZE;i++){
            if (i+WINDOWS_SIZE>ARRAY_SIZE){
                break;
            }
            ArrayList<Double> t1=new ArrayList<Double>(arrayList.subList(i,i+WINDOWS_SIZE));
            sublist.setArrayList(t1);
            minPerWindow=sublist.findMinOfArrayList();
            ascMin.add(minPerWindow);
        }
        return ascMin;
    }
}
