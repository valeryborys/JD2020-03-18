package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int posZero = 0;
        for (; ; ) {
            String inp = scanner.next();
            if (inp.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(inp);
            //-1 1 2 3 4 0 0 8 -2 -3 9 -7
            //1 2 3 4 8 9 0 0 -1 -2 -3 -7
            if (value < 0)
                list.add(value);
            else if (value == 0)
                list.add(posZero, value);
            else
                list.add(posZero++, value);
        }
        System.out.println(list);
    }
}
