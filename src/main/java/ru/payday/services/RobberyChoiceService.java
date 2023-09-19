package ru.payday.services;

import ru.payday.io.TextInput;
import ru.payday.io.TextOutput;
import ru.payday.model.DifficultyLevel;
import ru.payday.model.Robbery;

import static ru.payday.consts.Robberies.robberies;
import static ru.payday.consts.RobberyChoiceTextConsts.*;

public class RobberyChoiceService {
    public Robbery chooseRobbery(TextOutput output, TextInput input) {
        while (true) {
            output.println(ROBBERY_LIST_TEXT);
            for (int i = 0; i < robberies.size(); i++) {
                output.printf("%d. %s%n", (i + 1), robberies.get(i).getName());
            }
            output.print(ENTER_ROBBERY_NUMBER);
            int robberyChoice = input.nextInt();
            if (robberyChoice >= 1 && robberyChoice <= robberies.size()) {
                Robbery selectedRobbery = robberies.get(robberyChoice - 1);
                selectDifficulty(output, input, selectedRobbery);
                return selectedRobbery;
            } else {
                output.println(WRONG_NUMBER);
            }
        }
    }

    private void selectDifficulty(TextOutput output, TextInput input, Robbery selectedRobbery) {
        int difficultyChoice;
        do {
            output.println(CHOOSE_DIFFICULTY);
            for (int i = 0; i < DifficultyLevel.values().length; i++) {
                output.printf("%d. %s %s%n", (i + 1), DifficultyLevel.values()[i], DifficultyLevel.values()[i].getDistinction());
            }
            output.print(ENTER_DIFFICULTY_NUMBER);
            difficultyChoice = input.nextInt();
            if (difficultyChoice < 1 || difficultyChoice > DifficultyLevel.values().length) {
                output.println(WRONG_NUMBER);
            }
        } while (difficultyChoice < 1 || difficultyChoice > DifficultyLevel.values().length);

        DifficultyLevel selectedDifficulty = DifficultyLevel.values()[difficultyChoice - 1];
        selectedRobbery.setDifficultyLevel(selectedDifficulty);
        output.printf(CHOSEN_ROBBERY, selectedRobbery);
    }
}