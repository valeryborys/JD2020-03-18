package by.it.sinevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        int pos=0;
        while (!(str=sc.next()).equals("end")){
            Integer val = Integer.valueOf(str);
            if(val>0)
                list.add(pos++,val);
            else if(val==0)
                list.add(pos,0);
            else
                list.add(val);
            }
        System.out.println(list);
    }
}
