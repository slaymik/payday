package ru.payday.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static ru.payday.consts.GameConsts.*;
import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;

import ru.payday.consts.GameConsts;
import ru.payday.model.Scenario;

public class GameLoopService {
    static int scenarioSize = 0;
    static int fightCount;
    static boolean win = true;

    public static void gameLoopService() throws InterruptedException {
        System.out.printf("%s%n%n",welCum);
        Thread.sleep(threadSleepTime);
        Scanner scanner = new Scanner(System.in);
        CreatePlayerService.createPlayer();
        boolean playAgain = true;
        while (playAgain) {
            playPayDay();
            System.out.print("Хотите продолжить игру? (да/нет): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("Да");
        }
        System.out.printf("Ваш персонаж:%n%sКоличество пройденных ограблений: %d%nОбщее количество заработанных денег: %d%n%nСпасибо за игру!", CreatePlayerService.player, robberiesCount, totalReward);
        scanner.close();
    }

    private static void playPayDay() throws InterruptedException {
        Random random = new Random();
        RobberyChoiceService.robberyChoiceService();
        Thread.sleep(threadSleepTime);
        System.out.println();
        List<String> scenario = new ArrayList<>(Scenario.scenarios.get(robberyChoice - 1));
        fightCount = 0;
        for (int k = 0; k < scenario.size(); k++) {
            String line = scenario.get(k);
            System.out.println(line);
            double randomDouble = random.nextDouble();
            if (randomDouble < RobberyChoiceService.selectedRobberyEncounterProbability) {
                fightCount++;
                EncounterPlayer.createCop();
                boolean result = EncounterPlayer.fight();
                if (!result) {
                    win = false;
                    break;
                }
            }
            Thread.sleep(threadSleepTime);
            scenarioSize = k;
        }
            RobberyResultHandler.resultOutput();
        }
    }

