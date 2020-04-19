package by.it.novikov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String word;
        int position = 0;
        while ( !(word = sc.nextLine()).equals("end")) {
            int value = Integer.valueOf(word);
            if (value>0) {
                numbers.add(position++, value);
            }
            else if (value==0){
                numbers.add(position, value);
            }
            else if (value<0){
                numbers.add(value);
            }
        }
        System.out.println(numbers);

    }


}