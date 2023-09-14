import ru.payday.Human;

import java.util.*;

public class Cop extends Human {
    private double loseProbability;

    public Double getLoseProbability() {
        return loseProbability;
    }

    public void setLoseProbability(Double loseProbability) {
        this.loseProbability = loseProbability;
    }

    private static final Map<Double, String> rank = Map.of(
            0.1, "Рядовой",
            0.2, "Сержант",
            0.3, "Лейтенант",
            0.4, "Капитан",
            0.5, "Полковник"
    );
    public static List<String> copName = new ArrayList<>(Arrays.asList(
            "Олег", "Владимир", "Глеб", "Антон", "Санек"
    ));

    public static List<String> copNationality = new ArrayList<>(Arrays.asList(
            "Русский", "Немец", "Армянин", "Американец", "Украинец"
    ));
    public static List<String> copGender = new ArrayList<>(Arrays.asList(
            "Мужской", "Женский"
    ));

    public Cop(String name, int age, String nationality, String gender) {
        super(name, age, nationality, gender);
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String randomName = copName.get(random.nextInt(copName.size()));
        String randomNationality = copNationality.get(random.nextInt(copNationality.size()));
        String randomGender = copGender.get(random.nextInt(copGender.size()));
        int randomAge = random.nextInt(41) + 20;
        List<Double> rankProbabilities = new ArrayList<>(rank.keySet());
        double rankProbability = rankProbabilities.get(random.nextInt(rankProbabilities.size()));
        String randomRank = rank.get(rankProbability);
        Cop newCop = new Cop(randomName, randomAge, randomNationality, randomGender);
        newCop.setLoseProbability(rankProbability);


        System.out.printf("Вы встретили полицейского!%n Имя: %s%n Возраст: %d%n Национальность: %s%n Пол: %s%n Ранг: %s%n Вероятность выигрыша: %.2f%%%n%n",
                newCop.getName(), newCop.getAge(), newCop.getNationality(), newCop.getGender(),
                randomRank, (1 - newCop.getLoseProbability()) * 100);

        Thread.sleep(5000);
        System.out.println("Бой начинается!");
        Thread.sleep(1000);
        System.out.println("Производятся вычисления: ⌛");
        Thread.sleep(2000);
        double winProbability = random.nextDouble();
        boolean win;
        if (winProbability > newCop.loseProbability) {
            System.out.println("Вы победили!");
            win=true;
        }else{
            System.out.println("Вы проиграли!");
            win=false;
        }


    }
}

