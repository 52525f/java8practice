package com.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class ListSortTest {

    private List<Person> list;

    @BeforeMethod
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(new Person("Bob", "Jones", 32));
        list.add(new Person("John", "Doe", 30));
        list.add(new Person("Mike", "West", 10));
        list.add(new Person("Aaron", "Hammer", 38));
        list.add(new Person("Ross", "Jones", 32));
    }

    @Test
    public void sortsList() throws Exception {

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getAge() - p2.getAge() == 0) {
                    if(p1.getLastName().compareTo(p2.getLastName()) == 0) {
                        return p1.getFirstName().compareTo(p2.getFirstName());
                    } else {
                        return p1.getLastName().compareTo(p2.getLastName());
                    }
                } else {
                    return p1.getAge() - p2.getAge();
                }
            }
        });

        System.out.println(list);
    }

    @Test
    public void sortsListJava8() throws Exception {
        list.sort(Comparator.comparing(Person::getAge)
                .thenComparing(Person::getLastName)
                .thenComparing(Person::getFirstName));
        System.out.println(list);
    }
}
