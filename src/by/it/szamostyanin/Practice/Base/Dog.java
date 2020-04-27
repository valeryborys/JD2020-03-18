package by.it.szamostyanin.Practice.Base;

class Dog {
    //Поля класса
    private String name;
    private int age;
    private String race;


    //Конструктор класса №1
    public Dog(String name, int age, String race) {
        setName(name);
        setAge(age);
        setRace(race);
        System.out.println("Создали песика с именем " + getName());
    }

    //Конструктор класса №2
    public Dog() {
        System.out.println("Создали непонятного песика");
    }

    //Getter (метод класса)
    private String getName() {
        return this.name;
    }

    //Getter (метод класса)
    public int getAge() {
        return age;
    }

    //Getter (метод класса)
    public String getRace() {
        return race;
    }

    //Setter (метод класса)
    public void setName(String name) {
        this.name = name;
    }

    //Setter (метод класса)
    public void setAge(int age) {
        this.age = age;
    }

    //Setter (метод класса)
    public void setRace(String race) {
        this.race = race;
    }

    //Метод класса
    public void sayAboutU() {
        System.out.printf("Меня зовут %s, мне %d лет, я породы %s", getName(), getAge(), getRace());
    }

    //Метод класса
    public void voice() {
        System.out.println("Гав-гав!");
    }
}