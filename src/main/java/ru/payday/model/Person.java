package ru.payday.model;
import static ru.payday.consts.ModelsTextConsts.PERSON_TO_STRING_TEXT;
public class Person extends Human {
    public Person(String name, int age, String nationality, String gender) {
        super(name, age, nationality, gender);
    }
    public static int totalReward = 0;
    public static int robberiesCount = 0;
@Override
    public String toString() {
        return String.format(PERSON_TO_STRING_TEXT,
                name, age, nationality, gender);
    }
}