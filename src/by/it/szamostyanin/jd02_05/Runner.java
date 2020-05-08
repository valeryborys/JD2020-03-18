package by.it.szamostyanin.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static ResMan res;

    public static void main(String[] args) {
        res = ResMan.INSTANCE;
        System.out.println(res.getString(Message.LANGUAGE));
        Scanner scan = new Scanner(System.in);
        for (; ; ) {
            String expression = scan.nextLine();
            if (expression.equalsIgnoreCase("end")) {
                break;
            }
            switch (expression) {
                case "en": {
                    res.setLocale(new Locale(expression, "US"));
                    printText();
                    break;
                }
                case "ru": {
                    res.setLocale(new Locale(expression, "RU"));
                    printText();
                    break;
                }
                case "be": {
                    res.setLocale(new Locale(expression, "BY"));
                    printText();
                    break;
                }
                default: {
                    System.out.println(res.getString(Message.ERROR));
                }
            }
        }
    }

    private static void printText() {
        System.out.println(res.getString(Message.HELLO));
        System.out.println(res.getString(User.FIRST_NAME));
        System.out.println(res.getString(User.LAST_NAME));
        System.out.println(res.getDate().format(res.getFormatter()));
    }
}