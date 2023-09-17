package payday;

import payday.services.EncounterPlayer;
import ru.payday.consts.Scenarios;
import ru.payday.model.Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String playerName;
    private static int playerAge;
    private static String playerNationality;
    private static String playerGender;
    private static int total;

    public static void main(String[] args) {

        int chosenRobbery = 2;
        List<String> scenario = new ArrayList<>();
        scenario.addAll(Scenario.scenarios.get(chosenRobbery));

        for (int k = 0; k < scenario.size(); k++) {
            String line = scenario.get(k);
            System.out.println(line);

        }
    }
}
