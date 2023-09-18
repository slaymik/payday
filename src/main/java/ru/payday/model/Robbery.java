package ru.payday.model;
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
        return String.format("НАЗВАНИЕ: %s | ЛОКАЦИЯ: %s | УРОВЕНЬ СЛОЖНОСТИ: %s | НАГРАДА: $%d | ВЕРОЯТНОСТЬ ВСТРЕТИТЬ ПОЛИЦЕЙСКИХ: %.2f%%",
                name, location, difficultyLevel, money, policeEncounterProbability * 100);
    }
    public int getNumber() {
        return number;
    }
}