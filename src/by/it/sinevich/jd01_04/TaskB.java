package by.it.sinevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();
        }
        int[][] zp = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.printf("%10s%10s\n","Введите зарплату для ",name[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = sc.nextInt();
            }
        }
        int itogo=0;
        float max=0;
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s:",name[i]);
            for (int j = 0; j < 4; j++) {
                itogo+=zp[i][j];
                System.out.printf(" %-10d",zp[i][j]);
                if(j==3){
                    System.out.printf("%-10d %n",itogo);
                    max+=itogo;
                    itogo=0;
                }
            }
        }
        double sr =(double) max/(n*4);
        System.out.println("-------------------------------------------------------");
        System.out.printf("\n%-10s%-5.0f\n%-10s%-7.4f", "Итого",max,"Среднее",sr);
    }
}
