package by.it.borys.jd01_12;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] scopes = text.replaceAll("[^(){}\\[\\]]+", "").split("");
        ArrayDeque<String> scope = new ArrayDeque<>(Arrays.asList(scopes));
        System.out.println(rigthscopes(scope));
    }

    static boolean rigthscopes(ArrayDeque<String> scope) {
        ArrayDeque<String> arr = new ArrayDeque<>();
        int count = 0;//счетчик вернет false если количество закрытых скобок меньше, чем открытых
        for (String s : scope) {
            String str;
            if (s.equals("(") || s.equals("[") || s.equals("{")) {
                arr.add(s);
                count++;
                continue;
            } else{ str = arr.pollLast() + s;count--;
            if (str.equals("()")|| str.equals("{}") || str.equals("[]")) continue;
                else return false;
            }
        }
        if (count!=0)return false;
        else return true;
}


}
