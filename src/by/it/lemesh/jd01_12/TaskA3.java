package by.it.lemesh.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int position = 0;
        String str;
        while (!(str = sc.nextLine()).equals("end")) {
            int value = Integer.parseInt(str);
            if (value > 0) {
                list.add(position++, value);
            } else if (value == 0) {
                list.add(position, value);
            } else list.add(value);
        }
        System.out.println(list);
    }
}
