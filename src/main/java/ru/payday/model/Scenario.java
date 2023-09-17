package ru.payday.model;

import java.util.ArrayList;
import java.util.List;

import static ru.payday.consts.Scenarios.scenarioTexts;

public class Scenario {
    public static List<List<String>> scenarios = new ArrayList<>();
    static {
        for (int i = 0; i < scenarioTexts.length; i++) {
            List<String> scenario = new ArrayList<>();
            initializeScenario(scenarioTexts[i], scenario);
            scenarios.add(scenario);
        }
    }

    private static void initializeScenario(String text, List<String> scenarioList) {
        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            scenarioList.add(sentence.trim() + ".");
        }
    }
}
