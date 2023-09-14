public class Human {
    private final String name;
    private final int age;
    private final String nationality;
    private final String gender;

    public Human(String name, int age, String nationality, String gender) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }
}
