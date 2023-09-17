package ru.payday.services;

import ru.payday.model.Person;

import java.util.Scanner;

public class CreatePlayerService {
    private static String playerName;
    private static int playerAge;
    private static String playerNationality;
    private static String playerGender;
    static Person player = new Person();

    public static void createPlayer() {

        Scanner scanner = new Scanner(System.in);
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
                scanner.nextLine(); // Очистить буфер ввода
            }
        } while (true);
        System.out.print("Введите национальность: ");
        String nationality = scanner.nextLine();
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        player = new Person(name, age, nationality, gender);
        playerName = player.getName();
        playerAge = player.getAge();
        playerNationality = player.getNationality();
        playerGender = player.getGender();
        System.out.printf("Данные персонажа:%nИмя: %s%nВозраст: %d%nНациональность: %s%nПол: %s%n",
                playerName, playerAge, playerNationality, playerGender);
    }
@Override
    public String toString() {
        return String.format("%nИмя: %s%nВозраст: %d%nНациональность: %s%nПол: %s%n",
                playerName, playerAge, playerNationality, playerGender);
    }
}
