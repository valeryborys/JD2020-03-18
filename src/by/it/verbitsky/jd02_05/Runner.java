package by.it.verbitsky.jd02_05;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

class Runner {
    static {
        rm = ResourceManager.INSTANCE;
        scanner = new Scanner(System.in);
        date = LocalDate.now();
    }

    private static Scanner scanner;
    private static LocalDate date;
    private static ResourceManager rm;

    public static void main(String[] args) {
        checkArgs(args, rm);
        sayHello(rm);
        printDate(date);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("end")) {
                break;
            }
            setLocale(command);
            sayHello(rm);
            printDate(date);
        }
    }

    private static void printDate(LocalDate date) {
        System.out.println(date.format(rm.getDateFormat()));
    }

    private static void printArgs(String[] args) {
        System.out.print(MessageKeys.SYSTEM_ARGS);
        System.out.println(Arrays.toString(args));
    }

    private static void setLocale(String command) {
        switch (command) {
            case "en": {
                rm.setLocaleForBundle(new Locale(command, "US"));
                break;
            }
            case "ru": {
                rm.setLocaleForBundle(new Locale(command, "RU"));
                break;
            }
            case "be": {
                rm.setLocaleForBundle(new Locale(command, "BY"));
                break;
            }
        }
    }

    private static void sayHello(ResourceManager rm) {
        System.out.printf("%s, %s %s\n",
                rm.getMessage(MessageKeys.MESSAGE_HELLO),
                rm.getMessage(MessageKeys.USER_LNAME),
                rm.getMessage(MessageKeys.USER_FNAME));
    }

    private static void checkArgs(String[] args, ResourceManager rm) {
        if (args.length > 0) {
            printArgs(args);
            try {
                rm.setLocaleForBundle(new Locale(args[0], args[1]));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
