package ru.payday.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static ru.payday.consts.GameConsts.*;
import static ru.payday.consts.GameLoopTextConsts.*;
import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;
import ru.payday.io.TextInput;
import ru.payday.io.TextOutput;
import ru.payday.model.Cop;
import ru.payday.model.Person;
import ru.payday.model.Robbery;
import ru.payday.model.Scenario;
public class GameLoopService {
    public static void startGame(TextInput input, TextOutput output) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        output.printf("%s%n%n",WELCUM);
        Thread.sleep(THREAD_SLEEP_TIME);
        CreatePlayerService newPlayer = new CreatePlayerService();
        Person player = newPlayer.createPlayer(input,output);
        output.printf("%nВаш персонаж:%s",player);
        boolean playAgain = true;
        while (playAgain) {
            playPayDay(player,input,output);
            output.print(CONTINUE_PROMPT);
            String playAgainChoice = scanner.next();
            playAgain = isValidPlayAgainChoice(playAgainChoice);
        }
        output.printf(FINAL_RESULTS_MESSAGE,player, robberiesCount, totalReward);
        scanner.close();
    }
    private static boolean isValidPlayAgainChoice(String choice) {
        for (String validAnswer : VALID_YES_ANSWERS) {
            if (choice.equalsIgnoreCase(validAnswer)) {
                return true;
            }
        }
        return false;
    }
    private static void playPayDay(Person player, TextInput input,TextOutput output) throws InterruptedException {
        Random random = new Random();
        RobberyChoiceService newChoice = new RobberyChoiceService();
        Robbery selectedRobbery = newChoice.chooseRobbery(output, input);
        output.println("");
        List<String> scenario = new ArrayList<>(Scenario.scenarios.get(selectedRobbery.getNumber()-1));
        boolean result = true;
        long startTime = System.currentTimeMillis();
        for (String s : scenario) {
            Thread.sleep(THREAD_SLEEP_TIME);
            output.println(s);
            double randomDouble = random.nextDouble();
            if (randomDouble < selectedRobbery.getPoliceEncounterProbability()) {
                EncounterPlayer newEncounter = new EncounterPlayer(random);
                Cop newCop = newEncounter.createCop(output);
                result = newEncounter.fight(newCop, output);
                if (!result) {
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        RobberyResultHandler newResult = new RobberyResultHandler();
        newResult.resultOutput(output,player, selectedRobbery, result, startTime,endTime);
    }
}