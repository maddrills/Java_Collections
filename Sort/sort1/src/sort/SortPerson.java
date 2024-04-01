package sort;

import Entity.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortPerson {

    private List<Person> peoplePresent;

    public SortPerson(){
        this.peoplePresent = new ArrayList<>(List.of(
                new Person("Mat", 44, 25),
                new Person("Violet", 22, 23),
                new Person("George", 12, 28),
                new Person("Drake", 567, 44),
                new Person("Groin", 44, 55)));
    }


    public void comparableSorter(){

        peoplePresent.forEach(System.out::println);

        System.out.print("\n");
//        sorts by age asc
        peoplePresent.sort(null);

        /*person{name='Violet', rollNumber=22, age=23}
        person{name='Mat', rollNumber=44, age=25}
        person{name='George', rollNumber=12, age=28}
        person{name='Drake', rollNumber=567, age=44}
        person{name='Groin', rollNumber=44, age=55}*/
        peoplePresent.forEach(System.out::println);

    }

    public void comparatorSort(){

//        only have to provide what you are comparing
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        Comparator<Person> comparatorReversed = Comparator.comparing(Person::getName).reversed();

//        sort by name
        /*
        * person{name='Drake', rollNumber=567, age=44}
        person{name='George', rollNumber=12, age=28}
        person{name='Groin', rollNumber=44, age=55}
        person{name='Mat', rollNumber=44, age=25}
        person{name='Violet', rollNumber=22, age=23}*/
        peoplePresent.sort(comparator);
        System.out.print("\n");
        peoplePresent.forEach(System.out::println);

        /*
        * person{name='Violet', rollNumber=22, age=23}
        person{name='Mat', rollNumber=44, age=25}
        person{name='Groin', rollNumber=44, age=55}
        person{name='George', rollNumber=12, age=28}
        person{name='Drake', rollNumber=567, age=44}*/
        peoplePresent.sort(comparatorReversed);
        System.out.print("\n");
        peoplePresent.forEach(System.out::println);


        /*
        * person{name='George', rollNumber=12, age=28}
        person{name='Violet', rollNumber=22, age=23}
        person{name='Mat', rollNumber=44, age=25}
        person{name='Groin', rollNumber=44, age=55}
        person{name='Drake', rollNumber=567, age=44}*/
        Comparator<Person> normalStraightForward = (p1, p2) -> p1.getRollNumber() - p2.getRollNumber();
        peoplePresent.sort(normalStraightForward);
        System.out.print("\n");
        peoplePresent.forEach(System.out::println);
    }

}
