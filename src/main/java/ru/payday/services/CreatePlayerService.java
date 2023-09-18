package ru.payday.services;
import ru.payday.io.TextInput;
import ru.payday.io.TextOutput;
import ru.payday.model.Person;
import static ru.payday.consts.CreatePlayerTextConsts.*;
public class CreatePlayerService {
    public Person createPlayer(TextInput input, TextOutput output) {
        output.print(ENTER_NAME);
        String name = input.nextLine();
        output.print(ENTER_AGE);
        int age = input.nextInt();
        output.print(ENTER_NATIONALITY);
        String nationality = input.nextLine();
        output.print(ENTER_GENDER);
        String gender = input.nextLine();
        return new Person(name, age, nationality, gender);
    }
}