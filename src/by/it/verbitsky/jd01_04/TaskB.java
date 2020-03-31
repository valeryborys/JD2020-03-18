package by.it.verbitsky.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        String [] fams = new String[count];
        //System.out.println("Заполняем фамилии для "+count+ " человек");

        for (int i = 0; i < count; i++) {
            System.out.print(i+": ");
            fams[i] = scanner.next();
        }
/*
        for (String fam : fams) {
            System.out.println(fam);
        }   
 */
        int [][] zpArray = new int[count][4];
        for (int i = 0; i < count; i++) {
            System.out.println("Введите зарплату для "+fams[i]);
            for (int j = 0; j < 4; j++) {
                zpArray[i][j] = scanner.nextInt();
            }
        }


        int allAvg =0;
        int [] avgZp = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print(fams[i] +": ");
            int avg = 0;

            for (int j = 0; j < 4; j++) {
                avg+=zpArray[i][j];
                System.out.print(zpArray[i][j]+" ");
            }
            System.out.print(avg + "\n");
            avgZp[i] = avg;
            allAvg +=avg;
        }
        System.out.println("Итого "+allAvg);
        double midZp = 0;
        for (int i = 0; i < count; i++) {
            midZp += (double)avgZp[i]/4;
        }
        System.out.printf("Средняя %3.4f",midZp/count);





    }

    /*static int[] getArray(String line) {
        line = line.trim();
        String[] salary = line.split(" ");
        int[] arr = new int[salary.length];
        for (int i = 0; i < salary.length; i++) {
            if (!salary[i].equals(" "))
                arr[i] = Integer.parseInt(salary[i]);
        }
        return arr;
    }*/
}
