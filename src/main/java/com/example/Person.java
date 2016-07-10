package com.example;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Person(String myFirst, String myLast, int myAge) {
        firstName = myFirst;
        lastName = myLast;
        age = myAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

}
