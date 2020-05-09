package by.it.gutkovsky.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        ResMan res = ResMan.INSTANCE;
//        if(args.length==2){
//            Locale locale = new Locale(args[0], args[1]);
//            res.setLocale(locale);
//        }
        System.out.println("Please, choose locale (en)/ Калі ласка, абярыце мову (be) / Пожалуйста, выберите язык (ru)");
        Locale locale;
        Scanner sc = new Scanner(System.in);

        label:
        for (; ; ) {
            String expression = sc.nextLine();

            switch (expression) {
                case "end":
                case "скончыць":
                case "завершить":
                    break label;
                case "en":
                    locale = new Locale("en", "US");
                    res.setLocale(locale);
                    printInfo(res);
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    res.setLocale(locale);
                    printInfo(res);
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    res.setLocale(locale);
                    printInfo(res);
                    break;
                default:
                    System.out.println("Please, choose locale (en)/ Калі ласка, абярыце мову (be) / Пожалуйста, выберите язык (ru)");
                    break;
            }
        }

    }

    static void printInfo(ResMan res) {
        Date currentDate= new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, res.getLocale());
        String printDate = df.format(currentDate);

        System.out.println(printDate);
        System.out.println();
        System.out.println(res.get(Message.hello));
        System.out.println(res.get(Message.question));
        System.out.println(res.get(User.firstName));
        System.out.println(res.get(User.lastName));
    }
}
