package ru.payday.services;

import ru.payday.consts.Scenarios;
import ru.payday.model.Cop;
import ru.payday.consts.GameConsts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.payday.consts.CopParams.*;

public class EncounterPlayer {
    static double rankProbability;
    public static void createCop() throws InterruptedException {
        Thread.sleep(GameConsts.threadSleepTime);
        Random random = new Random();
        String randomName = copName.get(random.nextInt(copName.size()));
        String randomNationality = copNationality.get(random.nextInt(copNationality.size()));
        String randomGender = copGender.get(random.nextInt(copGender.size()));
        int randomAge = random.nextInt(ageDelta) +minAge;
        List<Double> rankProbabilities = new ArrayList<>(rank.keySet());
        rankProbability = rankProbabilities.get(random.nextInt(rankProbabilities.size()));
        String randomRank = rank.get(rankProbability);
        Cop newCop = new Cop(randomName, randomAge, randomNationality, randomGender,rankProbability);
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Вы встретили полицейского!%n%s%nРанг: %s%nВероятность выигрыша: %.2f%%%n%n",newCop,randomRank,(1 - newCop.getLoseProbability()) * 100);
}
    public static boolean fight() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(GameConsts.threadSleepTime);
        System.out.println("Бой начинается!");
        System.out.println("Производятся вычисления: ⌛");
        Thread.sleep(GameConsts.threadSleepTime);
        double winProbability = random.nextDouble();
        boolean win;
        int scenario;
        if (winProbability > rankProbability) {
            scenario = random.nextInt(Scenarios.scenarioFightsWon.length+1) ;
            System.out.printf("%s%nВы победили!%n----------------------------------------------------------------%n",Scenarios.scenarioFightsWon[scenario]);
            win=true;
        }else{
            scenario = random.nextInt(Scenarios.scenarioFightsLost.length+1) ;
            System.out.printf("%s%nВы проиграли!%n----------------------------------------------------------------%n",Scenarios.scenarioFightsLost[scenario]);
            win=false;
        }
        return win;

    }
}
