import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robbery {
    private final String name;
    private final String location;
    private DifficultyLevel difficultyLevel;
    private int Money;
    private double policeEncounterProbability;
    public Robbery(String name, String location){
        this.name = name;
        this.location = location;
    }
    public static final List<Robbery> robberies = new ArrayList<>();

     static {
        robberies.add(new Robbery("Ювелирный Магазин", "Лос-Анджелес"));
        robberies.add(new Robbery("Ограбление Банка", "Нью-Йорк"));
        robberies.add(new Robbery("Четыре Магазина", "Вашингтон"));
        robberies.add(new Robbery("Магазин Драгоценностей", "Остин"));
        robberies.add(new Robbery("Ограбление Транспорта", "Чикаго"));
    }
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getMoney() {
        return Money;
    }

    public double getPoliceEncounterProbability() {
        return policeEncounterProbability;
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        this.Money = generateMoney();
        this.policeEncounterProbability = generatePoliceEncounterProbability();
    }

    private int generateMoney() {
        // Генерируем количество денег в зависимости от сложности
        switch (difficultyLevel) {
            case EASY:
                return new Random().nextInt(20000) + 30000;
            case MEDIUM:
                return new Random().nextInt(30000) + 50000;
            case HARD:
                return new Random().nextInt(40000) + 80000;
            default:
                return 0;
        }
    }

    private double generatePoliceEncounterProbability() {
        // Генерируем случайную вероятность в зависимости от сложности
        double minProbability, maxProbability;
        switch (difficultyLevel) {
            case EASY:
                minProbability = 0.01;
                maxProbability = 0.1;
                break;
            case MEDIUM:
                minProbability = 0.11;
                maxProbability = 0.2;
                break;
            case HARD:
                minProbability = 0.21;
                maxProbability = 0.3;
                break;
            default:
                return 0.0;
        }

        return minProbability + new Random().nextDouble() * (maxProbability - minProbability);
    }

    @Override
    public String toString() {
        return "НАЗВАНИЕ: " + name + "| ЛОКАЦИЯ: " + location +
        "| УРОВЕНЬ СЛОЖНОСТИ: " + difficultyLevel +
                "| НАГРАДА: " + Money + "$" +
                "| ВЕРОЯТНОСТЬ ВСТРЕТИТЬ ПОЛИЦЕЙСКИХ: " + (policeEncounterProbability * 100) + "%";
    }
    enum DifficultyLevel {
        EASY,
        MEDIUM,
        HARD
    }
}
