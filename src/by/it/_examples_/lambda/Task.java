package by.it._examples_.lambda;

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        String line = "11,33,444,5,6,3,2,3,4,5,6,7,8,9,76,5";
        String[] array = line.split(",");
        int maxSize = array.length - 3;
        Arrays.stream(array)
                .limit(maxSize)
                .skip(3)
                .map(Integer::valueOf)
                .sorted((o1, o2) -> o2 - o1)
                .forEach(System.out::println);
    }
}
