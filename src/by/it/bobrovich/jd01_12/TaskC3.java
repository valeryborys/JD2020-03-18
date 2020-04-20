package by.it.bobrovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        Pattern pattern = Pattern.compile("[{}()\\[\\]]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String ch = matcher.group();
            list.add(ch);
        }
        System.out.println(check(list));
        System.out.println(list);
    }

    private static boolean check(List<String> list) {
        List<String> open = new ArrayList<>(Arrays.asList("{", "(", "["));
        List<String> close = new ArrayList<>(Arrays.asList("}", ")", "]"));
        Stack<String> stack = new Stack<>();
        if (list.size() % 2 != 0)
            return false;
        else{
            for (String s : list) {
                if(open.contains(s))
                    stack.push(s);
                if(close.contains(s)){
                    if(!stack.isEmpty()){
                        String str = stack.pop();
                        switch (s){
                            case "}" :{
                                if(!str.equals("{"))
                                    return false;
                                break;
                            }
                            case ")" :{
                                if(!str.equals("("))
                                    return false;
                                break;
                            }
                            case "]" :{
                                if(!str.equals("["))
                                    return false;
                                break;
                            }
                        }
                    } else
                        return false;
                }
            }
        }
        return true;
    }
}
