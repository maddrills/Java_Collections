package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------------");

        Map<String, Contact> contacts = new HashMap<>();

        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-----------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
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

        System.out.println("-----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
                ));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {
            /*
            * The computeIfAbsent method takes two parameters.
            * The first parameter is the key, and the second parameter is the mappingFunction.
            * It’s important to know that the mapping function is only called if the mapping isn’t present.*/
//            First, it checks if the key is present in the map. If the key is present, and a non-null value is related to the key, then it returns that value:
//            basically compute replaces the value in map with a computing function (k , v) -> new Contact(k);
//            computeIfAbsent takes only a key value as an arg key is 1st arg value is 2nd arg
            contacts.computeIfAbsent(contactName, k -> new Contact(k));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {
//            replaces if present provided key value must exist
            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place"); return v; });
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
//        replace all here updates all the values in a map
        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
//           replaceEmailIfExists is a method i made in the Contacts class
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");

//        replaces the value with a key input
//        contacts here is the map
//        returns the value that was replaced  or null if it didnt find any
        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

//        replaces based on a condition
        System.out.println("-----------------------------");
//        this only takes the contact data from daisy the name is still Daisy Duck
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
//        takes a key and replaces updatedDaisy with daisy
        //        contacts here is the map
//        replace here will only work if the .equals method says the names here are equal
//        make sure the name matches the name in the Map
//        so basically it only replaces the value if the key is matched and the value matches the value passes
        //replace(K key, V oldValue, V newValue) old and new must match
        boolean success = contacts.replace("Daisy Duck", daisy,
                updatedDaisy);
        if (success) {
            System.out.println("Successfully replaced element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));


//        removes a value if key and value (name) detected by .equals() as being == matches
        System.out.println("-----------------------------");
        success = contacts.remove("Daisy Duck", daisy);
        if (success) {
            System.out.println("Successfully removed element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", daisy));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

    }
}
