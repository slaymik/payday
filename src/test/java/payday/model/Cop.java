package payday.model;

import static ru.payday.consts.CopParams.*;

public class Cop extends Human {
    private double loseProbability;

    public Cop(String name, int age, String nationality, String gender, double loseProbability) {
        super(name, age, nationality, gender);
        this.loseProbability = loseProbability;
    }
    @Override
    public String toString(){
        return String.format("Имя: %s%n Возраст: %d%n Национальность: %s%n Пол: %s%n Ранг: %s%n", copName,getAge(),copNationality, copGender, rank);
    }


    public double getLoseProbability() {
        return loseProbability;
    }

    public void setLoseProbability(double loseProbability) {
        this.loseProbability = loseProbability;
    }
}

