package by.it.szamostyanin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int zero = 0;
        for (; ; ) {
            String scan = sc.next();
            if (scan.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(scan);
            if (value < 0)
                list.add(value);
            else if (value == 0)
                list.add(zero, value);
            else list.add(zero++, value);
        }
        System.out.println(list);
    }
}
