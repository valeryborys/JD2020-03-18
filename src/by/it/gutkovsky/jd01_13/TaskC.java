package by.it.gutkovsky.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

class TaskC {

    public static void main(String[] args) throws Exception {
        readData();
    }

    static void readData() throws Exception {
        Scanner sc = new Scanner(System.in);
        int countException = 0;
        LinkedList<Double> list = new LinkedList<>();
        while (true){
            try {
                String text = sc.nextLine();
                double number = Double.parseDouble(text);
                list.add(number);
            } catch (Exception e){
                countException++;
                if(countException <=5) {
                    Thread.sleep(100);
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.print(list.get(i)+" ");
                    }
                } else throw new Exception();
            }
        }
    }

}
