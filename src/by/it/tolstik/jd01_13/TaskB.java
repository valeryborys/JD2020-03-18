package by.it.tolstik.jd01_13;
import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;

        while (true) {
            String text = sc.nextLine();
            if (text.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(text);
                sum += number;
                if (sum <= 0) throw new ArithmeticException();
                System.out.println(number + " " + Math.sqrt(sum));

            } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                StackTraceElement[] trace = e.getStackTrace();
                for (StackTraceElement element : trace) {
                    if (element.getClassName().equals(TaskB.class.getName())) {
                        System.out.printf(
                                " name: %s\n" +"class: %s\n" +" line: %d\n"
                                , e.getClass().getName()
                                , element.getClassName()
                                , element.getLineNumber());
                        break;
                    }
                }
            }
        }
    }
}