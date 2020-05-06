package by.it.okatov.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    static boolean localeExists = false;

    public static void main(String[] args) {
        ResourcesManager manager = ResourcesManager.INSTANCE;
        Locale locale = Locale.getDefault();

        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }

        Scanner sc = new Scanner(System.in);
        String locInput;
        while (true) {
            System.out.println(manager.getString(Message.inputQuestion));
            System.out.print(manager.getString(Message.inputLocale) + " ");
            locInput = sc.nextLine();
            switch (locInput) {
                case Commands.be:
                    locale = new Locale(locInput, "BY");
                    localeExists = true;
                    break;
                case Commands.en:
                    locale = new Locale(locInput, "US");
                    localeExists = true;
                    break;
                case Commands.ru:
                    locale = new Locale(locInput, "RU");
                    localeExists = true;
                    break;
                case "end":
                    return;
                default:
                    String s = manager.getString(Message.msgErrorInputNotLocale);
                    System.out.println("\u001B[33m" + s);
                    System.out.println("\u001B[0m");
                    localeExists = false;
                    break;
            }
            manager.setLocale(locale);

            if (localeExists) {
                System.out.println(manager.getString(Message.hello));
                System.out.println(manager.getString(Message.question));
                System.out.println(manager.getString(User.name));
                System.out.println(manager.getString(User.surname));
                localeExists = false;
            }

        }


    }
}
