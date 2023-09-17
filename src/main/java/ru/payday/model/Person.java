package ru.payday.model;


public class Person extends Human {
    public Person(String name, int age, String nationality, String gender) {
        super(name, age, nationality, gender);
    }

    public Person() {
    }
    public static int totalReward = 0;
    public static int robberiesCount = 0;

    public String toString() {
        return String.format("%nИмя: %s%nВозраст: %d%nНациональность: %s%nПол: %s%n",
                name, age, nationality, gender);
    }
}
