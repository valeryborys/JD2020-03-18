package by.it.okatov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    static boolean localeExists = false;

    public static void main(String[] args) {
        ResourcesManager manager = ResourcesManager.INSTANCE;
        Locale locale = Locale.getDefault();


        //getLocaleFromArgs
        locale = getLocaleFromArgs(args, manager, locale);

        Scanner sc = new Scanner(System.in);
        inputLocaleCommand(manager, locale, sc);
    }

    private static Locale getLocaleFromArgs(String[] args, ResourcesManager manager, Locale locale) {
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        return locale;
    }

    private static void inputLocaleCommand(ResourcesManager manager, Locale locale, Scanner sc) {
        String locInput;
        while (true) {

            System.out.println(manager.getString(Message.inputQuestion));
            System.out.print(manager.getString(Message.inputLocale) + " ");
            locInput = sc.nextLine();
            switch (locInput) {
                case Commands.be:
                    locale = commandHandler(locInput, "BY");
                    break;
                case Commands.en:
                    locale = commandHandler(locInput, "US");
                    break;
                case Commands.ru:
                    locale = commandHandler(locInput, "RU");
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

            printText(manager, locale);

        }
    }

    private static Locale commandHandler(String locInput, String ru) {
        Locale locale;
        locale = new Locale(locInput, ru);
        localeExists = true;
        return locale;
    }

    private static void printText(ResourcesManager manager, Locale locale) {
        DateFormat df;
        Date date;
        manager.setLocale(locale);

        if (localeExists) {
            df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, locale);
            date = new Date();
            System.out.println(df.format(date));
            System.out.println(manager.getString(Message.hello));
            System.out.println(manager.getString(Message.question));
            System.out.println(manager.getString(User.name));
            System.out.println(manager.getString(User.surname));
            localeExists = false;
        }
    }
}
