package by.it.borys.jd02_03;

import by.it.borys.jd01_14.TaskA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    static final int K_SPEED = 100;

    private static final int PLAN = 100;
    private static final AtomicInteger inCount = new AtomicInteger(0);
    private static final AtomicInteger outCount = new AtomicInteger(0);
    public static final AtomicInteger inStoreRigthNow = new AtomicInteger(0);
    static boolean shopOpen(){
        return inCount.get()<PLAN;
    }
    static boolean planComplete(){
        return outCount.get() == PLAN;
    }

    static void buyerAddToShop(){
            inCount.getAndIncrement();
            inStoreRigthNow.getAndIncrement();

    }
    static void buyerLeaveTheShop(){
            outCount.getAndDecrement();
        inStoreRigthNow.getAndDecrement();
    }


static int buyersReg(int second, int inStore){
    int sec = second%60;
    int res = 0;
    if (sec <= 30) {
        res = 10 + sec - inStore;
        if (res < 0) res = 0;
    }
    return res;
}

  static TreeMap<Integer, Integer> graph = new TreeMap<>();

     static void printToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(TaskA.dir(Manager.class)+"log.txt")))
        {
            for (Map.Entry<Integer, Integer> el : graph.entrySet()) {
                pw.println(el.getKey()+" "+el.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
