package ru.payday.model;

import java.util.List;

import static ru.payday.consts.ModelsTextConsts.ROBBERY_TO_STRING_TEXT;

public class Robbery {
    private final String name;
    private final String location;
    private DifficultyLevel difficultyLevel;
    private int money;
    private double policeEncounterProbability;
    private final List<String> scenario;

    public Robbery(List scenario, String name, String location) {
        this.scenario = scenario;
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

    public List<String> getScenario() {
        return scenario;
    }
}