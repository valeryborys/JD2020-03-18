package by.it.borys.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество людей");
        int n = sc.nextInt();
        String[] surname = new String[n];
        sc.nextLine();
        System.out.println("Введите список фамилий");
        for (int i = 0; i < n; i++) {
          surname[i] = sc.nextLine();
      }


       /* for (int i = 0; i < surname.length; i++) {
            System.out.println(surname[i]);
        }*/
        int[][] zp = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+surname[i]);
            String zarplata =sc.nextLine();
            for (int j = 0; j < zp[0].length; j++) {
                String[] arr = zarplata.split(" ");
                zp[i][j] = Integer.parseInt(arr[j]);
            }
            }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-11s%-10s%-10s%-10s%-10s%s\n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4", "Итого");
        System.out.println("------------------------------------------------------");
int sumall = 0;
        for (int i = 0; i <n ; i++) {
            int sumquo =0;
            System.out.printf("%8s:  ",surname[i]);
            for (int j = 0; j < zp[0].length; j++) {
                System.out.printf("%-10d",zp[i][j]);
                sumquo += zp[i][j];

            }
            System.out.printf("%-5d",sumquo);
            System.out.println();
            sumall +=sumquo;

        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%8s:  %d\n","Итого",sumall);
        double avg = (double) sumall/12;
       // avg = new BigDecimal(avg).setScale(4, RoundingMode.HALF_UP).doubleValue();
        System.out.printf("%8s:  %6.4f","Средняя",avg);
    }

    }
