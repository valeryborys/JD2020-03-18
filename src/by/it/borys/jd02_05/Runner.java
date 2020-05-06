package by.it.borys.jd02_05;


import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Locale locale;
        ResMan res = ResMan.INSTANCE;
        System.out.println("Set locale(\"ru\",\"be\",\"en\"):");
        Scanner s = new Scanner(System.in);
        String set = s.nextLine();
        switch (set) {
            case ("ru"):
                locale = new Locale("ru","RU");
                res.setLocale(locale);
                break;
            case ("be"):
                locale = new Locale("be","BY");
                res.setLocale(locale);
                break;
            case ("en"):
                locale = new Locale("en","US");
                res.setLocale(locale);
                break;
                default:
                    System.out.println("Wrong locale. Result whith \"en\" locale:");
        }
//        if (args.length ==2){
//            locale = new Locale(args[0], args[1]);
//            res.setLocale(locale);
//        }
        SimpleDateFormat date = new SimpleDateFormat(res.get(DateF.date));
        String d = date.format(new Date());
        System.out.println(d);
        System.out.println(res.get(Message.hello));
        System.out.println(res.get(Message.question));
        System.out.println(res.get(User.firstName));
        System.out.println(res.get(User.lastName));
    }
}
