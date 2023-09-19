package ru.payday.services;
import ru.payday.consts.Scenarios;
import ru.payday.io.TextOutput;
import ru.payday.model.Cop;
import ru.payday.consts.GameConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static ru.payday.consts.CopParams.*;
import static ru.payday.consts.EncounterPlayerTextConsts.*;
public class EncounterPlayer {
    private final int minAge = 20;
    private final int ageDelta = 41;
    private final Random random;
    public EncounterPlayer(Random random){
        this.random = random;
    }
    public Cop createCop(){
        List<Double> rankProbabilities = new ArrayList<>(rank.keySet());
        return new Cop(copName.get(random.nextInt(copName.size())), random.nextInt(ageDelta) +minAge, copNationality.get(random.nextInt(copNationality.size())), copGender.get(random.nextInt(copGender.size())),rankProbabilities.get(random.nextInt(rankProbabilities.size())));
}
    public boolean fight(Cop newCop,TextOutput output) throws InterruptedException {
        Thread.sleep(GameConsts.THREAD_SLEEP_TIME);
        output.printf(FIGHT_START_TEXT);
        Thread.sleep(GameConsts.THREAD_SLEEP_TIME);
        double winProbability = random.nextDouble();
        boolean win;
        int copScenarioIndex;
        if (winProbability > newCop.getLoseProbability()) {
            copScenarioIndex = random.nextInt(Scenarios.scenarioFightsWon.length) ;
            output.printf(U_WON_TEXT,Scenarios.scenarioFightsWon[copScenarioIndex]);
            win=true;
        }else{
            copScenarioIndex = random.nextInt(Scenarios.scenarioFightsLost.length) ;
            output.printf(U_LOST_TEXT,Scenarios.scenarioFightsLost[copScenarioIndex]);
            win=false;
        }
        return win;
    }
}