package by.it.tolstik.jd02_05;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ResMan instance = ResMan.INSTANCE;
/*        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            instance.setLocale(locale);
            LocalDate date = LocalDate.now();
            DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
            System.out.println(date.format(pattern));
        }

        System.out.println(instance.get(Message.hello));
        System.out.println(instance.get(Message.question));
        System.out.println(instance.get(User.firstName));
        System.out.println(instance.get(User.lastName));*/

        System.out.println("======================================");
        System.out.println("Choose languages and enter to console:");
        System.out.println("ru - RUSSIAN");
        System.out.println("be - BELARUSIAN");
        System.out.println("en - ENGLISH");
        System.out.println("Waiting for your choice...");
        System.out.println("======================================");

        String input = scanner.next();
        switch (input) {
            case "ru":
                instance.locale = new Locale("ru", "RU");
                instance.setLocale(instance.locale);
                break;
            case "be":
                instance.locale = new Locale("be", "BY");
                instance.setLocale(instance.locale);
                break;
            case "en":
                instance.locale = new Locale("en", "US");
                instance.setLocale(instance.locale);
                break;
            default:
                System.err.println("Unknown command");
        }
        if (instance.locale != null) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(instance.locale);
            System.out.println(date.format(pattern));
            System.out.println(instance.get(Message.hello));
            System.out.println(instance.get(Message.question));
            System.out.println(instance.get(User.firstName));
            System.out.println(instance.get(User.lastName));
        }
    }
}

