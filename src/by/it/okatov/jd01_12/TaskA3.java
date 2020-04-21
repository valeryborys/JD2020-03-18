package by.it.okatov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input;
        Integer iValue;
        int positionOfZero = 0;
        while (true) {
            //2 4 6 8 9 7 5 3 1 0 0 -1 -3 -7 -5 -9 -8 -6 -4 -2 end
            input = sc.next();
            if (input.equals("end")) {
                break;
            }

            iValue = Integer.valueOf(input);
            if (iValue < 0) {
                list.add(iValue);
            } else if (iValue > 0) {
                list.add(positionOfZero++, iValue);
            } else {
                list.add(positionOfZero, iValue);
            }
        }

        System.out.println(list);
    }


}
