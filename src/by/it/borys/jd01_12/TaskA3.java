package by.it.borys.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> res  = new ArrayList<>();
        int posZero = 0;
        Scanner sc = new Scanner(System.in);
        for (;;) {
            String line = sc.next();
            if (line.equals("end")) {break;}
                Integer value = Integer.valueOf(line);
                if (value<0){
                    res.add(value);
                } else if (value==0){
                    res.add(posZero,value);
                }else res.add(posZero++, value);

        }
        System.out.println(res);
    }

}
