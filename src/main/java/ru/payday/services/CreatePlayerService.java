package ru.payday.services;

import ru.payday.model.Person;

import java.util.Scanner;

public class CreatePlayerService {

    public Person createPlayer(Scanner scanner) {

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
        Person player = new Person(name, age, nationality, gender);
        return player;
    }
}
