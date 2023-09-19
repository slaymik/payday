package ru.payday.io;

public interface TextOutput {
    void printf(String format, Object... args);

    void print(String line);

    void println(String line);
}