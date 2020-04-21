package by.it.verbitsky.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int endZero = 0;
        while (true) {
            String inp = scanner.next();
            if (inp.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(inp);

            if (value < 0) {
                list.add(value);

            } else if (value == 0) {
                list.add(endZero, value);

            } else {
                list.add(endZero++, value);
            }
        }
        System.out.println(list);
    }
}
