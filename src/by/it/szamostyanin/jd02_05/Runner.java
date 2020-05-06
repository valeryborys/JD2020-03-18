package by.it.szamostyanin.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan res = ResMan.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            res.setLocale(locale);
        }
        System.out.println(res.get(Message.question));
        System.out.println(res.get(Message.hello));
        System.out.println(res.get(User.firstName));
        System.out.println(res.get(User.lastName));
    }
}
