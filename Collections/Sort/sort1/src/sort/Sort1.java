package sort;

import java.util.ArrayList;
import java.util.List;

public final class Sort1 {

    private final List<Integer> peoplesList = new ArrayList<>(List.of(44,10,12,33,1));

    public Sort1() {}

    public void arrayListElementsUnsorted(){
        System.out.println(peoplesList);
    }

    private static Integer sortAsc(Integer a, Integer b){
        return a - b;
    }

    private static Integer sortDesc(Integer a, Integer b){
        return b - a;
    }


    public void sortedList(){
        this.peoplesList.sort(Sort1::sortAsc);
        System.out.println(peoplesList);
    }

}
