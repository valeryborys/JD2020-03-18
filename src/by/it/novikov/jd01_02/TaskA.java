package by.it.novikov.jd01_02;


import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int ma : mas) {
            if (ma < min) min = ma;
            if (ma > max) max = ma;

        }
        System.out.println(min+" "+max);

    }


    private static void step2(int[] mas) {
        double avg = 0;
        for (int value : mas) {
            avg = avg + value;
        }
        avg = avg / mas.length;
        for (int ma : mas) {
            if (ma < avg) System.out.print(ma + " ");
        }

    }
        private static void step3(int[] mas){
            int min = mas[0];
            for (int element : mas) {
                if (element < min) min = element;
            }
            for (int i = mas.length-1; i >=0 ; i--) {
                if (mas[i]==min)
                    System.out.print(i+" ");
            }
        }
}
