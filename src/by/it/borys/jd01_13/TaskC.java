package by.it.borys.jd01_13;


import java.util.*;

public class TaskC {
     private static Scanner sc;
    public static void main(String[] args) throws Exception {
       sc = new Scanner(System.in);
        readData();
    }


    static void readData() throws Exception {
        ArrayList<Double> queue = new ArrayList<>();
        int count = 0;
        while (count < 6) {
            String num = sc.next();
            try {
                double el = Double.valueOf(num);
                queue.add(el);
                } catch (NumberFormatException e) {
                if (count<5){
                    Thread.sleep(100);
                    for (int i = queue.size() - 1; i >= 0; i--) {
                        System.out.print(queue.get(i) + " ");
                    }
                    System.out.println();
                }
                count++;
            }
        }
        throw new Exception();
    }


}

