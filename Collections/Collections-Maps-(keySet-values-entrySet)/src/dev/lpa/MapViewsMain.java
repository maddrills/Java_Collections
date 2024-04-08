package dev.lpa;

import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
//        ContactData is a class and getData is a static method that returns an List of values
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

//        keySet() returns a set and not sorted
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

//        this will be sorted
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if (contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus and I go way back, so of course I have info");
        }

//        you can remove k v from a map by just its keys which are passed to a set
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

//        this is a deep copy of the map so removing from here will have no effect on the map
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k, v) -> System.out.println(v));

//        removes all the rest but the names in the list
        keysView.retainAll(List.of("Linus Van Pelt","Charlie Brown",
                "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
//        key view will automatically be filled because it has a previous association with contacts line15
        System.out.println(keysView);

//        returns a collection of items
        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("------------------");
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        System.out.println("------------------");
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() < contacts.keySet().size()) {
            System.out.println("Duplicate Values are in my Map");
        }

        var nodeSet = contacts.entrySet();
        for (var node : nodeSet) {
            System.out.println(nodeSet.getClass().getName());
            if (!node.getKey().equals(node.getValue().getName())) {
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn't match name: " + node.getKey() + ": " +
                        node.getValue());
            }
        }

    }
}
