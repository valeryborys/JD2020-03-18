package by.it.okatov.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(checkBrackets(sc.nextLine()));

    }

    static boolean checkBrackets(String input) {
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        if (input != null) {
            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    if (!result) {
                        result = true;
                    }
                } else if (c == ')' || c == ']' || c == '}') {
                    if (stack.empty()) {
                        result = false;
                        break;
                    } else {
                        char bracket = stack.pop();
                        if (!checkReverseBracket(bracket, c)) {
                            result = false;
                            break;
                        }
                    }
                }
            }
            if (!stack.empty()) {
                result = false;
            }
        }
        return result;
    }

    private static boolean checkReverseBracket(char operBracket, char closeBracket) {
        return (operBracket == '(' && closeBracket == ')') ||
                       (operBracket == '[' && closeBracket == ']') ||
                       (operBracket == '{' && closeBracket == '}');
    }
}
