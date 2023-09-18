package ru.payday.consts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class CopParams {
    public static final List<String> copName = new ArrayList<>(Arrays.asList(
            "Олег", "Владимир", "Глеб", "Антон", "Санек"
    ));
    public static final Map<Double, String> rank = Map.of(
            0.1, "Рядовой",
            0.2, "Сержант",
            0.3, "Лейтенант",
            0.4, "Капитан",
            0.5, "Полковник"
    );
    public static final List<String> copNationality = new ArrayList<>(Arrays.asList(
            "Русский", "Немец", "Армянин", "Американец", "Украинец"
    ));
    public static final List<String> copGender = new ArrayList<>(Arrays.asList(
            "Мужской", "Женский"
    ));
}