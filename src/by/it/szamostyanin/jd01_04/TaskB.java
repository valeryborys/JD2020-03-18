package by.it.szamostyanin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] sName = new String[n];
        for (int i = 0; i < sName.length; i++) {
            sName[i] = sc.nextLine();
            //System.out.println(sName[i]);
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length; j++) {
               //salary[i][j] = sc.nextLine();
            }
        }
    }
}
