package ru.payday.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static ru.payday.consts.GameConsts.*;
import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;

import ru.payday.model.Cop;
import ru.payday.model.Person;
import ru.payday.model.Robbery;
import ru.payday.model.Scenario;

public class GameLoopService {
    public static void startGame() throws InterruptedException {
        System.out.printf("%s%n%n",welCum);
        Thread.sleep(THREAD_SLEEP_TIME);
        Scanner scanner = new Scanner(System.in);
        CreatePlayerService newPlayer = new CreatePlayerService();
        Person player = newPlayer.createPlayer(scanner);
        System.out.printf("%nВаш персонаж:%s",player);
        boolean playAgain = true;
        while (playAgain) {
            playPayDay(player,scanner);
            System.out.print("Хотите продолжить игру? (да/нет): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("Да");
        }
        System.out.printf("Итоговые данные:%n%sКоличество пройденных ограблений: %d%nОбщее количество заработанных денег: %d%n%nСпасибо за игру!",player, robberiesCount, totalReward);
        scanner.close();
    }

    private static void playPayDay(Person player, Scanner scanner) throws InterruptedException {
        Random random = new Random();
        RobberyChoiceService newChoice = new RobberyChoiceService(scanner);
        Robbery selectedRobbery = newChoice.robberyChoiceService(scanner);
        System.out.println();
        List<String> scenario = new ArrayList<>(Scenario.scenarios.get(selectedRobbery.getRobberyNumber() - 1));
        boolean result = true;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < scenario.size(); i++) {
            Thread.sleep(THREAD_SLEEP_TIME);
            System.out.println(scenario.get(i));
            double randomDouble = random.nextDouble();
            if (randomDouble < selectedRobbery.getPoliceEncounterProbability()) {
                EncounterPlayer newEncounter = new EncounterPlayer(random);
                Cop newCop = newEncounter.createCop();
                result = newEncounter.fight(newCop);
                if (!result) {
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        RobberyResultHandler newResult = new RobberyResultHandler();
        newResult.resultOutput(player, selectedRobbery, result, startTime,endTime);
    }

}

