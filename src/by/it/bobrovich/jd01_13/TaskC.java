package by.it.bobrovich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        readData();
    }

    private static void readData(){
        int a = 0;
        List<Double> list = new ArrayList<>();
        while(true){
            try{
                Double number = Double.valueOf(sc.next());
                list.add(number);
            } catch (NumberFormatException e){
                if(a == 5)
                    throw new NumberFormatException();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                for (int i = list.size() - 1; i > -1; i--) {
                    System.out.print(list.get(i) + " ");
                }
                a++;
            }

        }
    }
}
