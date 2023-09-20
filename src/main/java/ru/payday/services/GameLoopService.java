package ru.payday.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.payday.consts.CopParams.rank;
import static ru.payday.consts.EncounterPlayerTextConsts.ENCOUNTERED_COP_DATA;
import static ru.payday.consts.GameConsts.*;
import static ru.payday.consts.GameLoopTextConsts.*;
import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;

import ru.payday.io.TextInput;
import ru.payday.io.TextOutput;
import ru.payday.model.Cop;
import ru.payday.model.Person;
import ru.payday.model.Robbery;

public class GameLoopService {
    public static void startGame(TextInput input, TextOutput output) throws InterruptedException {
        output.printf("%s%n%n", WELCUM);
        Thread.sleep(THREAD_SLEEP_TIME);
        CreatePlayerService newPlayer = new CreatePlayerService();
        Person player = newPlayer.createPlayer(input, output);
        output.printf("%n%s", player);
        boolean playAgain = true;
        while (playAgain) {
            playPayDay(player, input, output);
            output.print(CONTINUE_PROMPT);
            String playAgainChoice = input.nextLine();
            playAgain = isValidPlayAgainChoice(playAgainChoice);
        }
        output.printf(FINAL_RESULTS_MESSAGE, player, robberiesCount, totalReward);
    }

    private static boolean isValidPlayAgainChoice(String choice) {
        for (String validAnswer : VALID_YES_ANSWERS) {
            if (choice.equalsIgnoreCase(validAnswer)) {
                return true;
            }
        }
        return false;
    }

    private static void playPayDay(Person player, TextInput input, TextOutput output) throws InterruptedException {
        Random random = new Random();
        RobberyChoiceService newChoice = new RobberyChoiceService();
        Robbery selectedRobbery = newChoice.chooseRobbery(output, input);
        output.println("");
        List<String> scenario = new ArrayList<>(selectedRobbery.getScenario());
        boolean result = true;
        long startTime = System.currentTimeMillis();
        for (String s : scenario) {
            Thread.sleep(THREAD_SLEEP_TIME);
            output.println(s);
            double randomDouble = random.nextDouble();
            if (randomDouble < selectedRobbery.getPoliceEncounterProbability()) {
                EncounterPlayer newEncounter = new EncounterPlayer(random);
                Cop newCop = newEncounter.createCop();
                output.printf(ENCOUNTERED_COP_DATA, newCop, rank.get(newCop.getLoseProbability()), (1 - newCop.getLoseProbability()) * 100);
                result = newEncounter.fight(newCop, output);
                if (!result) {
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        Thread.sleep(THREAD_SLEEP_TIME);
        RobberyResultHandler newResult = new RobberyResultHandler();
        newResult.resultOutput(output, player, selectedRobbery, result, startTime, endTime);
    }
}