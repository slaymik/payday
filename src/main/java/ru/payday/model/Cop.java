package ru.payday.model;

import static ru.payday.consts.ModelsTextConsts.COP_TO_STRING_TEXT;

public class Cop extends Human {
    private final double loseProbability;

    public Cop(String name, int age, String nationality, String gender, double loseProbability) {
        super(name, age, nationality, gender);
        this.loseProbability = loseProbability;
    }

    @Override
    public String toString() {
        return String.format(COP_TO_STRING_TEXT, getName(), getAge(), getNationality(), getGender());
    }

    public double getLoseProbability() {
        return loseProbability;
    }
}