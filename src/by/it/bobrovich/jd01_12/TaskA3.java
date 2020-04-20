package by.it.bobrovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        while(!(str = sc.next()).equals("end")){
            Integer value = Integer.valueOf(str);
            if(value>0)
                list.add(pos++, value);
            else if (value == 0)
                list.add(pos, value);
            else
                list.add(value);
        }
        System.out.println(list);

    }
}
