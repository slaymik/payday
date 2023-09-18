package ru.payday.services;
import ru.payday.consts.Scenarios;
import ru.payday.io.TextOutput;
import ru.payday.model.Cop;
import ru.payday.consts.GameConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static ru.payday.consts.CopParams.*;
public class EncounterPlayer {
    private final int minAge = 20;
    private final int ageDelta = 41;
    private final Random random;
    public EncounterPlayer(Random random){
        this.random = random;
    }
    public Cop createCop(TextOutput output){
        List<Double> rankProbabilities = new ArrayList<>(rank.keySet());
        Cop newCop = new Cop(copName.get(random.nextInt(copName.size())), random.nextInt(ageDelta) +minAge, copNationality.get(random.nextInt(copNationality.size())), copGender.get(random.nextInt(copGender.size())),rankProbabilities.get(random.nextInt(rankProbabilities.size())));
        output.println("----------------------------------------------------------------");
        output.printf("Вы встретили полицейского!%n%s%nРанг: %s%nВероятность выигрыша: %.2f%%%n%n",newCop,rank.get(newCop.getLoseProbability()),(1 - newCop.getLoseProbability()) * 100);
        return newCop;
}
    public boolean fight(Cop newCop,TextOutput output) throws InterruptedException {
        Thread.sleep(GameConsts.THREAD_SLEEP_TIME);
        output.printf("Бой начинается!%nПроизводятся вычисления: ⌛%n");
        Thread.sleep(GameConsts.THREAD_SLEEP_TIME);
        double winProbability = random.nextDouble();
        boolean win;
        int copScenarioIndex;
        if (winProbability > newCop.getLoseProbability()) {
            copScenarioIndex = random.nextInt(Scenarios.scenarioFightsWon.length) ;
            output.printf("%s%nВы победили!%n----------------------------------------------------------------%n",Scenarios.scenarioFightsWon[copScenarioIndex]);
            win=true;
        }else{
            copScenarioIndex = random.nextInt(Scenarios.scenarioFightsLost.length) ;
            output.printf("%s%nВы проиграли!%n----------------------------------------------------------------%n",Scenarios.scenarioFightsLost[copScenarioIndex]);
            win=false;
        }
        return win;
    }
}