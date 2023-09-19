package ru.payday.model;

import java.util.Random;

import static ru.payday.consts.ModelsTextConsts.*;

public enum DifficultyLevel {
    EASY(DIFFICULTY_EASY_DISTINCTION, 30000, 20000, 0.01, 0.1),
    MEDIUM(DIFFICULTY_MEDIUM_DISTINCTION, 50000, 30000, 0.11, 0.2),
    HARD(DIFFICULTY_HARD_DISTINCTION, 80000, 40000, 0.21, 0.3);
    private final int minMoney;
    private final int moneyDelta;
    private final double minProbability;
    private final double maxProbability;
    private final String distinction;

    public String getDistinction() {
        return distinction;
    }

    DifficultyLevel(String distinction, int minMoney, int moneyDelta, double minProbability, double maxProbability) {
        this.distinction = distinction;
        this.minMoney = minMoney;
        this.moneyDelta = moneyDelta;
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
    }

    public int generateMoney() {
        return minMoney + new Random().nextInt(moneyDelta);
    }

    public double generatePoliceEncounterProbability() {
        return minProbability + new Random().nextDouble() * (maxProbability - minProbability);
    }
}