package evalTest;


import java.util.ArrayList;



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
    int windowsSize;
    /**
     * This variable represents the array to be used
     */
    ArrayList<Double> arrayList;
    /**
     * This variable represents the array size
     */
    int arraySize;

    /**
     * This is the void constructor method of the class, used for initialization
     */
    AscendingMinima(){}

    /**
     * This is the main constructor method of the class, used for initialization
     *
     * @param ws The window size
     * @param arrayList The array to be used
     *
     * @throws IllegalArgumentException when the window size is not positive
     * @throws IllegalArgumentException when the window size is greater than the array size
     * @throws IllegalArgumentException when the array list is empty
     *
     */
    AscendingMinima(int ws,  ArrayList<Double> arrayList){
        setWindowsSize(ws);
        setArrayList(arrayList);
        this.arraySize=arrayList.size();
    }

    /**
     * The getter method for the window size variable
     *
     * @return the windows size, in integer value
     */
    public int getWindowsSize(){
        return windowsSize;
    }

    /**
     * The getter method for array size
     *
     * @return the current array size, as an integer value
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * The getter method for the array List
     *
     * @return the array list, as an array list of doubles
     */
    public ArrayList<Double> getArrayList() {
        return arrayList;
    }

    /**
     * The setter method for the array list
     *
     * @param arrayList the new array list, as an array list of doubles
     *
     * @throws IllegalArgumentException when the array is empty
     */
    public void setArrayList(ArrayList<Double> arrayList) {
        if (arrayList.size()==0){
            throw new IllegalArgumentException("Array is empty. Can't use algorithm");
        }
        this.arrayList = arrayList;
    }

    /**
     * The setter method for the window size
     *
     * @param windowsSize the new window size, as an integer value
     *
     * @throws IllegalArgumentException when the window size is not positive
     * @throws IllegalArgumentException when the window size is greater than the array size
     */
    public void setWindowsSize(int windowsSize) {
        if(windowsSize<=0){
            throw new IllegalArgumentException("Window size must be positive, found: " +windowsSize);
        }
        if (windowsSize>arraySize){
            throw new IllegalArgumentException("Window size can't be greater than array size but found: window size=" +windowsSize+" array size="+arraySize);
        }
        this.windowsSize = windowsSize;
    }

    /**
     * This method creates and initializes the window to be used for the algorithm. It adds to the first window the first
     * elements of the array list
     *
     * @return the first window
     */
    public ArrayList<Double> initializeWindow(){
        //Create empty window with capacity as great as the window size
        ArrayList<Double> window=new ArrayList<>(windowsSize);
        //Add to the window the first WINDOW_SIZE elements of the array list, so as to create the first window
        for (int i=0;i<windowsSize;i++){
            window.add(arrayList.get(i));
        }

        return window;
    }

    /**
     * The implementation of the algorithm. While the window is not out of bounds, the algorithm finds the minimum value
     * of the sublist created from the indexes and adds it to a Linked List
     *
     * @return a Linked List containing all the minimum values found for each window
     */
    public ArrayList<Double> findAscendingMinima() {
        //initialize window
        ArrayList<Double> window=initializeWindow();
        //Initialize the ascending minima array to be returned with capacity as great as the array size minus the window
        //size plus 1. If the array size is 5 and the window size is 3 then the algorithm will go as follows:
        //0-1-2, 1-2-3, 2-3-4, end. That means the algorithm will find 3 minimums to return and so 5-3+1=3.
        ArrayList<Double> ascMin=new ArrayList<>(arraySize-windowsSize+1);
        //find the minimum of the first window and add it to the arraylist to be returned
        ascMin.add(StatisticalUtilsArrayList.findMinOfArrayList(window));

        for(int i=1;i<arraySize-windowsSize+1;i++){
            //remove the first element from the window
            window.remove(0);
            //add the next element from the array list to the window
            window.add(arrayList.get(i+windowsSize-1));
            //find the minimum of the current window and add it to the arraylist to be returned
            ascMin.add(StatisticalUtilsArrayList.findMinOfArrayList(window));
        }

        return ascMin;
    }
}
