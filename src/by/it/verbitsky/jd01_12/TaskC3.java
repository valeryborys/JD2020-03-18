package by.it.verbitsky.jd01_12;

import java.util.*;

class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*
        String str = "{[{()}][()]{()}}";
        String str2 = "{}";
        System.out.println(checkBrackets(str));
        System.out.println(checkBrackets(str2));
        LinkedList <String> list = new LinkedList<>();
        list.push("1");
        list.push("2");
        list.push("3");
        list.push("4");
        list.push("5");
        System.out.println(list);
*/
        String word = scanner.nextLine();
        System.out.println(checkBrackets(word));
    }

    private static boolean checkBrackets(String str) {
        boolean res = false;
        String open = "{[(<";
        String close = "}])>";
        LinkedList<String> openedBrackets = new LinkedList<>();

        for (char c : str.toCharArray()) {
            //Если след. символ - открытая скобка - ложим в очередь
            String symbol = String.valueOf(c);
            if (open.contains(symbol)) {
                openedBrackets.push(symbol);
            }
            //Если след. символ - закрытая скобка
            //достаем из стека первый символ и сравниваем
            if (close.contains(symbol)) {
                //если стек не пустой - сравниваем закрытую скобку с последней открытой
                //если стек пустой - значит не хватает открывающей скобки
                if (!openedBrackets.isEmpty()) {
                    //берем последнюю открытую скобку и проверяем была ли она закрыта
                    String oBracket = openedBrackets.pollFirst();
                    switch (symbol) {
                        case "}": {
                            if (!oBracket.equals("{")) {
                                return false;
                            }
                            break;
                        }
                        case ")": {
                            if (!oBracket.equals("(")) {
                                return false;
                            }
                            break;
                        }
                        case "]": {
                            if (!oBracket.equals("[")) {
                                return false;
                            }
                            break;
                        }
                        case ">": {
                            if (!oBracket.equals("<")) {
                                return false;
                            }
                            break;
                        }
                    }
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
