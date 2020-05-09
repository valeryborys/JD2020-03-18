package by.it.lemesh.jd02_05;


import java.util.Locale;
import java.util.Scanner;


public class Runner {

    static ResMan res = ResMan.INSTANCE;

    public static void main(String[] args) {
        printConsole();
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            setLocale(line);
            printConsole();
        }
    }

    private static void printConsole() {
        System.out.printf("%s\n%s %s\n",
                res.get(Message.hello),
                res.get(User.firstName),
                res.get(User.lastName));
        System.out.println(res.getDate());
    }

    private static void setLocale(String line) {
        switch (line) {
            case "ru": {
                res.setLocale(new Locale(line, "RU"));
                break;
            }
            case "be": {
                res.setLocale(new Locale(line, "BY"));
                break;
            }
            case "en": {
                res.setLocale(new Locale(line, "US"));
                break;
            }
        }
    }
}

