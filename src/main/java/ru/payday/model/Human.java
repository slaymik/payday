package ru.payday.model;

public class Human {
    protected String name;
    protected int age;
    protected String nationality;
    protected String gender;

    public Human(String name, int age, String nationality, String gender) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }
}