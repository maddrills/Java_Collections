package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* when putting a value in the map
* if key exists then the value in replaced and the old value is returned
* else key value is inserted
* */
public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------------");

//        it doesnt have an add all method
        Map<String, Contact> contacts = new HashMap<>();

        for (Contact contact : fullList) {
//            inserting element in map
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
//        getting an element by key
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

//        if you dont want a null point exception a defaultContact will be returned

        Contact defaultContact = new Contact("Chuck Brown");

//        returns an element if it does exist
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
//                key will be the same but the associated data will be merged together
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
//            putIfAbsent only puts a value if it is void does not do anything if it has a value
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

//        the bellow does a continuous merge
        System.out.println("-----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
                ));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

    }
}
