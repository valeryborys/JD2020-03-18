package by.it.okatov.calc;


import by.it.okatov.calc.globalization.*;
import by.it.okatov.calc.logsystem.LogSystem;
import by.it.okatov.jd01_15.TaskB;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    private static boolean localeExists = false;
    public static ResourceManager manager = ResourceManager.INSTANCE;

    public static void main(String[] args) {
        //enableloggerSystem
        enableLoggerSystem(true);


        Locale locale;

        locale = getLocaleFromArgs(args, manager);
        localeExists = true;

        Scanner sc = new Scanner(System.in);


        inputLocaleCommands(manager, locale, sc);


        //programCycle
        programCycle(sc, manager, locale);
    }

    private static void inputLocaleCommands(ResourceManager manager, Locale locale, Scanner sc) {
        System.out.println(manager.getString(IMessage.msgInputQuestion));
        System.out.println(manager.getString(IMessage.msgInputLocale) + " ");
        String locInput = sc.nextLine();
        switch (locInput) {

            case ICommand.be:
                locale = commandHandler(locInput, "BY");

                break;
            case ICommand.ru:
                locale = commandHandler(locInput, "RU");

                break;
            case ICommand.en:
                locale = commandHandler(locInput, "US");
                break;
            default:
                String s = manager.getString(IError.msgErrorInputNotLocale);
                System.out.println("\u001B[33m" + s);
                System.out.println("\u001B[0m");
                localeExists = false;
                break;
        }
        printText(manager, locale);
    }

    private static void printText(ResourceManager manager, Locale locale) {
        manager.setLocale(locale);
        if (localeExists) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, locale);
            Date date = new Date();
            System.out.println("\u001B[33m");
            System.out.println(df.format(date));
            System.out.println(manager.getString(IMessage.msgHello));
            System.out.println(manager.getString(IUser.author));
            System.out.print(manager.getString(IUser.name) + " ");
            System.out.println(manager.getString(IUser.surname));
            System.out.println(manager.getString(IMessage.msgCommandsToInput));
            System.out.println(manager.getString(IMessage.variables));
            System.out.println(manager.getString(IMessage.msgScalar));
            System.out.println(manager.getString(IMessage.msgVector));
            System.out.println(manager.getString(IMessage.msgMatrix));
            System.out.println(manager.getString(IMessage.msgAnonVars));
            System.out.println(manager.getString(IMessage.msgOperations));
            System.out.println(manager.getString(IMessage.msgLanguage));
            System.out.println(manager.getString(IMessage.msgLanguageCommands));
            System.out.println(manager.getString(IMessage.msgGLHF));
            System.out.println("\u001B[0m");

            localeExists = false;
        }

    }

    private static Locale commandHandler(String language, String country) {
        Locale locale = new Locale(language, country);
        localeExists = true;
        return locale;
    }

    private static Locale getLocaleFromArgs(String[] args, ResourceManager manager) {
        Locale locale;
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        } else {
            locale = Locale.getDefault();
        }
        localeExists = true;
        return locale;
    }

    private static void programCycle(Scanner sc, ResourceManager manager, Locale locale) {
        Parser parse = new Parser();
        Printer print = new Printer();

        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")) {
                return;
            }
            //Если пользователь ввел printVar, то вызываем одноименный метод для печати выражения
            switch (expression) {
                case "printVar":
                case "printvar":
                    Parser.printVar();
                    continue;
                case "sortVar":
                case "sortvar": //Если пользователь ввел sortVar, то вызываем одноименный метод для сортировки выражения
                    Parser.sortVar();
                    continue;
                case "set locale":
                case "установить локаль":
                case "ўсталяваць лакаль":
                    inputLocaleCommands(manager, locale, sc);
                    continue;
            }

            try {
                Var var = parse.calc(expression);
                print.print(var);
            } catch (CalcException calcException) {
                System.out.println(calcException.getMessage());
            }

        }
    }

    private static void enableLoggerSystem(@SuppressWarnings("SameParameterValue") boolean isEnabled) {
        if (isEnabled) {
            try (
                    PrintStream out = new PrintStream(
                            new FileOutputStream(
                                    TaskB.getFileName(
                                            LogSystem.class, "DebugLog.log"
                                    )
                            )
                    )
            ) {
                PrintStream logger = new LogSystem(System.out, out);
                System.setOut(logger);
                System.setErr(new LogSystem(System.err, out));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
