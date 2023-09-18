package ru.payday.services;
import ru.payday.model.DifficultyLevel;
import ru.payday.model.Robbery;
import java.util.Scanner;
import static ru.payday.consts.Robberies.robberies;

public class RobberyChoiceService {
    private Scanner scanner;

    public RobberyChoiceService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Robbery robberyChoiceService(Scanner scanner) {
        int robberyChoice;
        while (true) {
            System.out.println("Список ограблений:");
            for (int i = 0; i < robberies.size(); i++) {
                System.out.printf("%d. %s%n",(i + 1),robberies.get(i).getName());
            }
            System.out.print("Выберите ограбление (введите номер): ");
            String input = scanner.nextLine();
            try {
                robberyChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введено нечисловое значение. Пожалуйста, введите число.");
                continue;
            }

            if (robberyChoice >= 1 && robberyChoice <= robberies.size()) {
                Robbery selectedRobbery = robberies.get(robberyChoice - 1);
                selectedRobbery.setRobberyNumber(robberyChoice);
                selectedRobbery= selectDifficulty(scanner, selectedRobbery);
                return selectedRobbery;
            } else {
                System.out.println("Неверный выбор ограбления. Пожалуйста, выберите снова.");
            }
        }
    }

    private Robbery selectDifficulty(Scanner scanner, Robbery selectedRobbery) {
        while (true) {
            int difficultyChoice;
            System.out.println("Выберите уровень сложности:");
            for (int i = 0; i < DifficultyLevel.values().length; i++) {
                System.out.printf("%d. %s%n", (i + 1), DifficultyLevel.values()[i]);
            }
            System.out.print("Введите номер уровня сложности: ");
            String input = scanner.nextLine();
            try {
                difficultyChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введено нечисловое значение. Пожалуйста, введите число.");
                continue;
            }

            if (difficultyChoice >= 1 && difficultyChoice <= DifficultyLevel.values().length) {
                DifficultyLevel selectedDifficulty = DifficultyLevel.values()[difficultyChoice - 1];
                selectedRobbery.setDifficultyLevel(selectedDifficulty);
                System.out.printf("Вы выбрали следующее ограбление:%n%s%n", selectedRobbery);
                return selectedRobbery;
            } else {
                System.out.println("Неверный выбор уровня сложности. Пожалуйста, выберите снова.");
            }
        }
    }
}
