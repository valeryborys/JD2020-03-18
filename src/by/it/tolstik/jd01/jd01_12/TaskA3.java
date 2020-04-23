package by.it.tolstik.jd01.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        int pos = 0;
        while (!(text = scanner.next()).equals("end")) {
            int value = Integer.parseInt(text);
            if (value > 0) {
                list.add(pos++, value);
            } else if (value == 0) {
                list.add(pos, 0);
            } else {
                list.add(value);
            }
            System.out.println(list);
        }
    }
}
