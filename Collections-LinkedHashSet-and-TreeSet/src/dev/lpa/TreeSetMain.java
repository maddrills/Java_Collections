package dev.lpa;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
//        you need a sorting algorithm to make TreeSet work
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
//        NavigableSet interface implements the sortedSet interface
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

//        you dont need a comparater here because each node here is of type string and TreeSet has anatural sort order
        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

//        here the sort was extracted from sorted tree set along with that sets values
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
//        you can also add more but redundent values will be removed
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
//        extracting the comparator from sorted TreeSet
        fullList.sort(sorted.comparator());
        System.out.println("--------------------------");
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("--------------------------");
        System.out.printf("min = %s, first=%s %n", min.getName(), first.getName());
        System.out.printf("max = %s, last=%s %n", max.getName(), last.getName());
        System.out.println("--------------------------");

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
//        pole first and last removes that element from the set and returns it
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("--------------------------");

    }
}
