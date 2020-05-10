package by.it.novikov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        char[] charArray = words.toCharArray();
        ArrayList<Character> bracketsList = new ArrayList<>();
        for (char c : charArray) {
            if (isOpenBracket(c) >= 0 || isClosedBracket(c) >= 0) {
                bracketsList.add(c);
            }
        }
        System.out.println(bracketsList);
        System.out.println(isRight(bracketsList));
    }

    static int isOpenBracket(Character character) {
        List<Character> openBrackets = new ArrayList<>(Arrays.asList('{', '(', '['));
        if (openBrackets.contains(character)) {
            return openBrackets.indexOf(character);
        } else return -1;
    }

    static int isClosedBracket(Character character) {
        List<Character> closedBrackets = new ArrayList<>(Arrays.asList('}', ')', ']'));
        if (closedBrackets.contains(character)) {
            return closedBrackets.indexOf(character);
        } else return -1;
    }

    static boolean isRight(ArrayList<Character> array) {
        boolean isRight = true;
        List<Character> arrayOfBrackets = new ArrayList<>();
        for (Character character : array) {
            if (arrayOfBrackets.size() == 0 && isOpenBracket(character) == -1) {
                return false;
            } else if (isOpenBracket(character) > -1) {
                arrayOfBrackets.add(character);
            } else if (isClosedBracket(character) > -1) {
                if (isOpenBracket(arrayOfBrackets.get(arrayOfBrackets.size() - 1)) == isClosedBracket(character)) {
                    arrayOfBrackets.remove(arrayOfBrackets.size() - 1);
                } else {
                    return false;
                }
            }
        }
        if (arrayOfBrackets.size() > 0) {
            return false;
        }
        return isRight;


    }
}