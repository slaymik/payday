package ru.payday.model;

import java.util.Random;
public class Robbery {
    private String name = null;
    private String location = null;
    private DifficultyLevel difficultyLevel;
    private int Money;
    private double policeEncounterProbability;
    public Robbery(String name, String location){
        this.name = name;
        this.location = location;
    }
    public Robbery(){}

    public String getName() {
        return name;
    }
    public int getMoney() {
        return Money;
    }
    public double getPoliceEncounterProbability() {
        return policeEncounterProbability;
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        this.Money = generateMoney();
        this.policeEncounterProbability = generatePoliceEncounterProbability();
    }
    private int generateMoney() {
        // Генерируем количество денег в зависимости от сложности
        switch (difficultyLevel) {
            case EASY:
                int minMoney = 30000;
                int moneyDelta = 20000;
                return new Random().nextInt(moneyDelta) + minMoney;
            case MEDIUM:
                minMoney = 50000;
                moneyDelta = 30000;
                return new Random().nextInt(moneyDelta) + minMoney;
            case HARD:
                minMoney = 80000;
                moneyDelta = 40000;
                return new Random().nextInt(moneyDelta) + minMoney;
            default:
                return 0;
        }
    }
    private double generatePoliceEncounterProbability() {
        double minProbability;
        double maxProbability;
        switch (difficultyLevel) {
            case EASY:
                minProbability = 0.01;
                maxProbability = 0.1;
                break;
            case MEDIUM:
                minProbability = 0.11;
                maxProbability = 0.2;
                break;
            case HARD:
                minProbability = 0.21;
                maxProbability = 0.3;
                break;
            default:
                return 0.0;
        }
        return minProbability + new Random().nextDouble() * (maxProbability - minProbability);
    }
    @Override
    public String toString() {
        return String.format("НАЗВАНИЕ: %s | ЛОКАЦИЯ: %s | УРОВЕНЬ СЛОЖНОСТИ: %s | НАГРАДА: $%d | ВЕРОЯТНОСТЬ ВСТРЕТИТЬ ПОЛИЦЕЙСКИХ: %.2f%%",
                name, location, difficultyLevel, Money, policeEncounterProbability * 100);
    }

}

