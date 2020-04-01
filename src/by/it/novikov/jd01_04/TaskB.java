package by.it.novikov.jd01_04;



import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String fam = scan.next();
            arr[i] = fam;
        }
        //Ввод
        int i;
        i = 0;
        int[][] zpmatrix = new int[n][4];
        for (int k = 0; k < n; k++) {
            int j;
            j = 0;
            System.out.println("Введите зарплату для " + arr[i]);
            zpmatrix[k][j] = scan.nextInt();
            zpmatrix[k][j + 1] = scan.nextInt();
            zpmatrix[k][j + 2] = scan.nextInt();
            zpmatrix[k][j + 3] = scan.nextInt();
            i++;
        }
        //Вывод
        i=0;
        for (int k = 0; k < n; k++) {
            System.out.print(arr[i]+":");
            i++;
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + zpmatrix[k][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < 4; j++) {
                sum = sum + zpmatrix[k][j];
            }
        }
        System.out.println("Итого " + sum);
        double sred = (double) sum / (n * 4);
        System.out.printf("Средняя%7.4f", sred);
        System.out.println();
        i=0;

        for (int k = 0; k < n; k++) {
            int summ = 0;

            for (int j = 0; j < 4; j++) {
                summ += zpmatrix[k][j];
            }
            System.out.println(arr[i] +" итого: "+ summ);
            i++;
        }

// ПРОБУЮ

        System.out.println("----------------------------------------------------");
        System.out.printf("%-10s %-5s %-5s %-5s %-5s %-6s %n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------");
        i=0;
        for (int k = 0; k < n; k++) {
            int summ = 0;
            System.out.printf("%-10s ",arr[i]);
            i++;
            for (int j = 0; j < 4; j++) {

                System.out.printf("%-8d ", zpmatrix[k][j]);
                summ=summ+zpmatrix[k][j];

            } System.out.printf("%-6d ",summ);
            System.out.println();
        }
        System.out.println("----------------------------------------------------");
        System.out.printf("%-10s %-8d  %n","Итого",sum);
        System.out.printf("%-10s %-8.4f  %n","Средняя",sred);


    }


}
