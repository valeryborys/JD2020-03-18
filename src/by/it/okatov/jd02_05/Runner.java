package by.it.okatov.jd02_05;

public class Runner {
    public static void main(String[] args) {
        if (args.length != 0) {
        }

        ResourcesManager manager = ResourcesManager.INSTANCE;
        System.out.println(manager.getString(Message.question));
    }
}
