package by.it.bobrovich.jd02_05;


import java.util.Calendar;

public class Runner {
    public static void main(String[] args) {
        ResMan res = ResMan.INSTANCE;
        Calendar date = Calendar.getInstance();
        System.out.println(res.getString(Message.hello));
        System.out.println(res.getString(Message.question));
        System.out.println(res.getString(User.firstName));
        System.out.println(res.getString(User.lastName));
        System.out.println(date);
    }
}
