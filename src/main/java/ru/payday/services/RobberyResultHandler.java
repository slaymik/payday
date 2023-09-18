package ru.payday.services;
import ru.payday.model.Person;
import ru.payday.model.Robbery;

import static ru.payday.model.Person.robberiesCount;
import static ru.payday.model.Person.totalReward;

public class RobberyResultHandler {
    public void resultOutput(Person player, Robbery selectedRobbery, boolean result, long startTime, long endTime){
        float duration = (endTime - startTime)/1000;
        String isWon = (result)?"Успех":"Провал";
        totalReward = (result)? totalReward + selectedRobbery.getMoney(): totalReward;
        robberiesCount = (result)? robberiesCount+1:robberiesCount;
        int money = (result)?selectedRobbery.getMoney():0;
        System.out.printf("%nВы закончили миссию!%n%n%s%nУспешность: %s%n%nПродолжительность: %.2f секунд(ы)%n%nНаграда: %d$%n%nСумма всех наград: %d$%n",
               player, isWon,duration, money, totalReward);
    }
}
