package ru.payday.consts;

import ru.payday.model.Robbery;

import java.util.ArrayList;
import java.util.List;

public class Robberies {
    public static final List<Robbery> robberies = new ArrayList<>();

    static {
        robberies.add(new Robbery("Ювелирный Магазин", "Лос-Анджелес"));
        robberies.add(new Robbery("Ограбление Банка", "Нью-Йорк"));
        robberies.add(new Robbery("Четыре Магазина", "Вашингтон"));
        robberies.add(new Robbery("Магазин Драгоценностей", "Остин"));
        robberies.add(new Robbery("Ограбление Транспорта", "Чикаго"));
    }
}
