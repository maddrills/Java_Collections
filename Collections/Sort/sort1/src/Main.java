import sort.Sort1;
import sort.SortPerson;

public class Main {
    public static void main(String[] args) {
        Sort1 sort1 = new Sort1();

        sort1.arrayListElementsUnsorted();

        sort1.sortedList();

        SortPerson person1 = new SortPerson();

        person1.comparableSorter();

        person1.comparatorSort();
    }
}