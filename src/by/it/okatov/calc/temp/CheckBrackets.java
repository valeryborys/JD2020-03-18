package by.it.okatov.calc.temp;

import java.util.Stack;

public class CheckBrackets {

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
