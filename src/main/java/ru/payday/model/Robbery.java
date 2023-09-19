package ru.payday.model;
import static ru.payday.consts.ModelsTextConsts.ROBBERY_TO_STRING_TEXT;
public class Robbery {
    private final String name;
    private final String location;
    private DifficultyLevel difficultyLevel;
    private int money;
    private double policeEncounterProbability;
    private final int number;
    public Robbery(int number,String name, String location){
        this.number = number;
        this.name = name;
        this.location = location;
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        this.money = difficultyLevel.generateMoney();
        this.policeEncounterProbability = difficultyLevel.generatePoliceEncounterProbability();
    }
    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }
    public double getPoliceEncounterProbability() {
        return policeEncounterProbability;
    }
    @Override
    public String toString() {
        return String.format(ROBBERY_TO_STRING_TEXT,
                name, location, difficultyLevel, money, policeEncounterProbability * 100);
    }
    public int getNumber() {
        return number;
    }
}