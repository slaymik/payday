package ru.payday;
import ru.payday.io.ConsoleScannerTextInput;
import ru.payday.io.ConsoleTextOutput;
import ru.payday.io.TextInput;
import ru.payday.io.TextOutput;

import static ru.payday.services.GameLoopService.startGame;


public class Main {
    private static final TextInput input = new ConsoleScannerTextInput();
    private static final TextOutput output = new ConsoleTextOutput();

    public static void main(String[] args) throws InterruptedException {
        startGame(input,output);
        }
    }

