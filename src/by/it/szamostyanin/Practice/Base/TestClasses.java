package by.it.szamostyanin.Practice.Base;

public class TestClasses {
    public static void main(String[] args) {
        Dog dog1 = new Dog(); //объект класса Dog
        Dog dog2 = new Dog("Meet", 2, "pes-kotleta"); //Объект/экземпляр класса Dog

        dog1.sayAboutU(); //Вызво метода у объекта (то что умеет делать экземпляр)
        System.out.println();
        dog2.sayAboutU();
        System.out.println("-------------------------");

        dog1.setName("Шавка");
        dog1.setAge(3);
        dog1.setRace("двортеръер");

        System.out.println("-------------------------");

        dog1.sayAboutU();

        dog1.voice();
        dog2.voice();

        int a =1;
        int b =2;
        int c;
        c=a+b;



    }
}
