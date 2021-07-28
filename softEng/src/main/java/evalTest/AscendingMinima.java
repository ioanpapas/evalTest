package evalTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AscendingMinima {

    int WINDOWS_SIZE;
    int ARRAY_SIZE;
    ArrayList<Double> arrayList;

    AscendingMinima(){};

    AscendingMinima(int ws, int as, ArrayList<Double> arrayList){
        this.WINDOWS_SIZE=ws;
        this.ARRAY_SIZE=as;
        this.arrayList=arrayList;
    }

    public Queue<Double> findAscendingMinima() {
        Queue<Double> ascMin=new LinkedList<Double>();
        StatisticalUtilsArrayList sublist=new StatisticalUtilsArrayList();
        double minPerWindow;
        for(int i=0;i<ARRAY_SIZE;i++){
            sublist.setArrayList((ArrayList<Double>)arrayList.subList(i,i+WINDOWS_SIZE));
            minPerWindow=sublist.findMinOfArrayList();
            ascMin.add(minPerWindow);
        }
        return ascMin;
    }
}
