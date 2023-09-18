package ru.payday.consts;
import ru.payday.model.Robbery;
import java.util.ArrayList;
import java.util.List;
public class Robberies {
    public static final List<Robbery> robberies = new ArrayList<>();
    static {
        robberies.add(new Robbery(1,"Ювелирный Магазин", "Лос-Анджелес"));
        robberies.add(new Robbery(2,"Ограбление Банка", "Нью-Йорк"));
        robberies.add(new Robbery(3,"Четыре Магазина", "Вашингтон"));
        robberies.add(new Robbery(4,"Магазин Драгоценностей", "Остин"));
        robberies.add(new Robbery(5,"Ограбление Транспорта", "Чикаго"));
    }
}