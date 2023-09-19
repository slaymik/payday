package ru.payday.consts;

import ru.payday.model.Robbery;
import ru.payday.model.Scenario;

import java.util.ArrayList;
import java.util.List;

public class Robberies {
    public static final List<Robbery> robberies = new ArrayList<>();

    static {
        robberies.add(new Robbery(Scenario.scenarios.get(0), "Ювелирный Магазин", "Лос-Анджелес"));
        robberies.add(new Robbery(Scenario.scenarios.get(1), "Ограбление Банка", "Нью-Йорк"));
        robberies.add(new Robbery(Scenario.scenarios.get(2), "Четыре Магазина", "Вашингтон"));
        robberies.add(new Robbery(Scenario.scenarios.get(3), "Магазин Драгоценностей", "Остин"));
        robberies.add(new Robbery(Scenario.scenarios.get(4), "Ограбление Транспорта", "Чикаго"));
    }
}