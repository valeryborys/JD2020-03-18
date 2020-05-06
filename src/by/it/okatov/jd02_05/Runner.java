package by.it.okatov.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourcesManager manager = ResourcesManager.INSTANCE;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }


        System.out.println(manager.getString(Message.hello));
        System.out.println(manager.getString(Message.question));
        System.out.println(manager.getString(User.name));
        System.out.println(manager.getString(User.surname));
    }
}
