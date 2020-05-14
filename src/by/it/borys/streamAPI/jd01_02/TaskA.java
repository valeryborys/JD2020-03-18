package by.it.borys.streamAPI.jd01_02;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
            step1(mas);
        }

    }
    static void step1(int[] mas) {
        OptionalInt min = Arrays.stream(mas).min();
        if(min.isPresent()) System.out.println(min.getAsInt());
    }
}
