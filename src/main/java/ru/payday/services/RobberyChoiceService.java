package ru.payday.services;
import ru.payday.io.TextInput;
import ru.payday.io.TextOutput;
import ru.payday.model.DifficultyLevel;
import ru.payday.model.Robbery;
import static ru.payday.consts.Robberies.robberies;
public class RobberyChoiceService {
    public Robbery chooseRobbery(TextOutput output, TextInput input) {
        while (true) {
            output.println("Список ограблений:");
            for (int i = 0; i < robberies.size(); i++) {
                output.printf("%d. %s%n",(i + 1),robberies.get(i).getName());
            }
            output.print("Выберите ограбление (введите номер): ");
            int robberyChoice = input.nextInt();
            if (robberyChoice >= 1 && robberyChoice <= robberies.size()) {
                Robbery selectedRobbery = robberies.get(robberyChoice - 1);
                selectDifficulty(output, input, selectedRobbery);
                return selectedRobbery;
            } else {
                output.println("Неверный выбор ограбления. Пожалуйста, выберите снова.");
            }
        }
    }
    private void selectDifficulty(TextOutput output, TextInput input, Robbery selectedRobbery) {
        int difficultyChoice;
        do {
            output.println("Выберите уровень сложности:");
            for (int i = 0; i < DifficultyLevel.values().length; i++) {
                output.printf("%d. %s %s%n", (i + 1), DifficultyLevel.values()[i],DifficultyLevel.values()[i].getDistinction());
            }
            output.print("Введите номер уровня сложности: ");
            difficultyChoice = input.nextInt();
            if (difficultyChoice < 1 || difficultyChoice > DifficultyLevel.values().length) {
                output.println("Неверный выбор уровня сложности. Пожалуйста, выберите снова.");
            }
        } while (difficultyChoice < 1 || difficultyChoice > DifficultyLevel.values().length);

        DifficultyLevel selectedDifficulty = DifficultyLevel.values()[difficultyChoice - 1];
        selectedRobbery.setDifficultyLevel(selectedDifficulty);
        output.printf("Вы выбрали следующее ограбление:%n%s%n", selectedRobbery);
    }
}