package payday.services;

import payday.consts.GameConsts;
import payday.model.Cop;

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
        System.out.printf("Вы встретили полицейского!%n%s%nРанг: %s",newCop,randomRank);
}
    public static boolean fight() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(GameConsts.threadSleepTime);
        System.out.println("Бой начинается!");
        Thread.sleep(GameConsts.threadSleepTime);
        System.out.println("Производятся вычисления: ⌛");
        Thread.sleep(GameConsts.threadSleepTime);
        double winProbability = random.nextDouble();
        boolean win;
        if (winProbability > rankProbability) {
            System.out.println("Вы победили!");
            win=true;
        }else{
            System.out.println("Вы проиграли!");
            win=false;
        }
        return win;

    }
}
