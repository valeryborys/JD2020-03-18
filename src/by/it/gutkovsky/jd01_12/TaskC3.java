package by.it.gutkovsky.jd01_12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(bracketCheck(sc.nextLine()));
    }

    private static boolean bracketCheck(String line) {
        // '{' '(' '[' ']' ')' '}'
        boolean result = false;
        if (line != null) {
            Deque<Character> openBrackets = new LinkedList<>();
            char[] inputs = line.toCharArray();
            // заполнение очереди открывающимися скобками
            for (char input : inputs) {
                if (input == '{' || input == '(' || input == '[') {
                    openBrackets.addLast(input); // каждый новый элемент добавляю в в конец очереди
                    if (!result) {
                        result = true;
                    }
                } else {
                    if (input == '}' || input == ')' || input == ']') {
                        if (openBrackets.isEmpty()) { // если закрывающаяся скобка появилась первой, то false и выходим из метода
                            result = false;
                            break;
                        } else {
                            char element = openBrackets.removeLast();
                            if ((element == '{' && input == '}') || (element == '[' && input == ']') || (element == '(' && input == ')')) {
                                result = true;
                            } else {
                                result = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (!openBrackets.isEmpty()) {
                result = false;
            }
        }
        return result;
    }
}
