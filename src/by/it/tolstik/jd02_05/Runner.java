package by.it.tolstik.jd02_05;

import java.util.Locale;

class Runner {
    public static void main(String[] args) {
        ResMan instance = ResMan.INSTANCE;
        if(args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            instance.setLocale(locale);
        }

        System.out.println(instance.get(Message.hello));
        System.out.println(instance.get(Message.question));
        System.out.println(instance.get(User.firstName));
        System.out.println(instance.get(User.lastName));
    }
}
