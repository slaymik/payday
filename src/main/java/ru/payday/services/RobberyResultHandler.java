package ru.payday.services;
import static ru.payday.consts.GameConsts.*;
import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;
import static ru.payday.services.GameLoopService.*;
import static ru.payday.services.RobberyChoiceService.selectedRobbery;

public class RobberyResultHandler {
    public static void resultOutput(){
        int totalDuration = fightCount*fightTime+startDuration+scenarioSize*5;
        String won = (win)?"Не попался":"Попался";
        totalReward = (win)? totalReward + selectedRobbery.getMoney(): totalReward;
        robberiesCount = (win)? robberiesCount+1:robberiesCount;
        int money = (win)?selectedRobbery.getMoney():0;
        System.out.printf("%nВы закончили миссию!%n%n%s%nУспешность: %s%n%nПродолжительность: %d секунд%n%nНаграда: %d$%n%nСумма всех наград: %d$%n",
               CreatePlayerService.player, won,totalDuration, money, totalReward);
    }
}
