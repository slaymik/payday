package ru.payday.services;
import ru.payday.io.TextOutput;
import ru.payday.model.Person;
import ru.payday.model.Robbery;
import static ru.payday.consts.RobberyResultTextConsts.*;
import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;
public class RobberyResultHandler {
    public void resultOutput(TextOutput output, Person player, Robbery selectedRobbery, boolean result, long startTime, long endTime){
        long duration = (endTime - startTime)/1000;
        String isWon = result?IS_WON_WON:IS_WON_LOST;
        totalReward = result? totalReward + selectedRobbery.getMoney(): totalReward;
        robberiesCount = result? robberiesCount+1:robberiesCount;
        int money = result?selectedRobbery.getMoney():0;
        output.printf(RESULTS_TEXT,
               player, isWon,duration, money, totalReward);
    }
}