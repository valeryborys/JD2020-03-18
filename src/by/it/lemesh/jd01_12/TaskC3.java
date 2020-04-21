package by.it.lemesh.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        boolean result = true;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        if (chars.length % 2 > 0) result = false;

        ArrayList<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }

        while ((list.size() > 1) && (result)) {
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i) == '}') | (list.get(i) == ')') | (list.get(i) == ']')) {
                    result = charEquals(list.get(i), list.get(i - 1));
                    list.remove(i - 1);
                    list.remove(i - 1);
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean charEquals(Character char1, Character char2) {
        if ((char1 == ')') && (char2 == '(')) return true;
        else if ((char1 == '}') && (char2 == '{')) return true;
        else return (char1 == ']') && (char2 == '[');
    }

}
