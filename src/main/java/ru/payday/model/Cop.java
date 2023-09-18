package ru.payday.model;
public class Cop extends Human {
    private final double loseProbability;
    public Cop(String name, int age, String nationality, String gender, double loseProbability) {
        super(name, age, nationality, gender);
        this.loseProbability = loseProbability;
    }
    @Override
    public String toString(){
        return String.format("Имя: %s%nВозраст: %d%nНациональность: %s%nПол: %s",getName(),getAge(),getNationality(), getGender());
    }
    public double getLoseProbability() {
        return loseProbability;
    }
}