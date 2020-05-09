package by.it.bobrovich.jd02_05;


import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    static ResMan res;
    static Date date;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        res = ResMan.INSTANCE;
        date = new Date();
        label:
        while(true){
            line = sc.nextLine();
            switch (line){
                case "be":{
                    Locale locale = new Locale("be", "BY");
                    printMessage(locale);
                    continue label;
                }
                case "ru":{
                    Locale locale = new Locale("ru", "RU");
                    printMessage(locale);
                    continue label;
                }
                case "en":{
                    Locale locale = new Locale("en", "US");
                    printMessage(locale);
                    continue label;
                }
                case "end":{
                    break label;
                }
            }
        }
    }

    public static void printMessage(Locale locale){
        res.setLocale(locale);
        System.out.println(res.getString(Message.hello));
        System.out.println(res.getString(Message.question));
        System.out.println(res.getString(User.firstName));
        System.out.println(res.getString(User.lastName));
        res.showDate(date, DateFormat.dateFormat);
    }
}
