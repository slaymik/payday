package ru.payday;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String playerName;
    private static int playerAge;
    private static String playerNationality;
    private static String playerGender;
    private static int total;
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        total = 0;
        int age;
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        do {
            System.out.print("Введите возраст: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Ошибка: Возраст должен быть числом. Пожалуйста, введите снова.");
                scanner.nextLine();
            }
        } while (true);
        System.out.print("Введите национальность: ");
        String nationality = scanner.nextLine();
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        Person player = new Person(name, age, nationality, gender);
        playerName = player.getName();
        playerAge = player.getAge();
        playerNationality = player.getNationality();
        playerGender = player.getGender();
        System.out.printf("Данные персонажа:%nИмя: %s%nВозраст: %d%nНациональность: %s%nПол: %s%n",
                playerName, playerAge, playerNationality, playerGender);
        boolean playAgain = true;
        while (playAgain) {
            playPayDay(scanner);

            System.out.print("Хотите продолжить игру? (да/нет): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("Да");
        }
        System.out.println("Спасибо за игру!");
        scanner.close();
    }
    private static void playPayDay(Scanner scanner) throws InterruptedException {
        Random random = new Random();
        while (true) {
            System.out.println("Список ограблений:");
            for (int i = 0; i < Robbery.robberies.size(); i++) {
                System.out.println((i + 1) + ". " + Robbery.robberies.get(i).getName());
            }
            System.out.print("Выберите ограбление (введите номер): ");
            int robberyChoice = scanner.nextInt();
            if (robberyChoice >= 1 && robberyChoice <= Robbery.robberies.size()) {
                Robbery selectedRobbery = Robbery.robberies.get(robberyChoice - 1);
                while (true) {
                    System.out.println("Выберите уровень сложности:");
                    for (int i = 0; i < Robbery.DifficultyLevel.values().length; i++) {
                        System.out.printf("%d. %s%n", (i + 1), Robbery.DifficultyLevel.values()[i]);
                    }
                    System.out.print("Введите номер уровня сложности: ");
                    int difficultyChoice = scanner.nextInt();
                    if (difficultyChoice >= 1 && difficultyChoice <= Robbery.DifficultyLevel.values().length) {
                        Robbery.DifficultyLevel selectedDifficulty = Robbery.DifficultyLevel.values()[difficultyChoice - 1];
                        selectedRobbery.setDifficultyLevel(selectedDifficulty);
                        System.out.printf("Вы выбрали следующее ограбление:%n%s%n", selectedRobbery);
                        int totalDelayTime = 5;
                        Thread.sleep(5000);
                        System.out.println();
                        Robbery.initializeScenarios();
                        List<String> scenario = new ArrayList<>();
                        if (robberyChoice == 1) {
                            scenario.addAll(Robbery.scenario1);
                        } else if (robberyChoice == 2) {
                            scenario.addAll(Robbery.scenario2);
                        } else if (robberyChoice == 3) {
                            scenario.addAll(Robbery.scenario3);
                        } else if (robberyChoice == 4) {
                            scenario.addAll(Robbery.scenario4);
                        } else {
                            scenario.addAll(Robbery.scenario5);}
                        boolean win = true;
                        int fightTime = 0;
                        int scenarioSize = 0;
                        for(int k=0;k<scenario.size();k++){
                            String line = scenario.get(k);
                            System.out.println(line);
                            double randomDouble = random.nextDouble();
                            if(randomDouble< selectedRobbery.getPoliceEncounterProbability()){
                                fightTime += 7;
                                boolean result = Cop.fight();
                                if(!result){
                                    win=false;
                                    k++;
                                    break;
                                }
                            }
                            Thread.sleep(5000);
                            scenarioSize = k;
                        }
                        totalDelayTime = fightTime+totalDelayTime+scenarioSize*5;
                        String won = (win)?"Не попался":"Попался";
                        total = (win)?total+ selectedRobbery.getMoney():total;
                        int money = (win)?selectedRobbery.getMoney():0;
                        System.out.printf("%nВы закончили миссию%n%nИмя: %s%nВозраст: %d%nНациональность: %s%nПол: %s%n%n Успешность: %s%n%n Продолжительность: %d секунд%n%n Награда: %d$%n%n Сумма всех наград: %d$%n",
                                playerName, playerAge, playerNationality, playerGender, won,totalDelayTime, money,total);
                        break;
                    } else {
                        System.out.println("Неверный выбор уровня сложности. Пожалуйста, выберите снова.");
                    }
                }
                break;
            } else {
                System.out.println("Неверный выбор ограбления. Пожалуйста, выберите снова.");
            }
        }
    }
}
