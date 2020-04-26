package by.it.gutkovsky.jd02_02;

import java.util.Iterator;
import java.util.Map;

class Cashier implements Runnable {
    private String name;
    static final Object MONITOR2 = new Object();
    private static volatile double TotalSum = 0;


    Cashier(int number) {
        name = "\tCashier № " + number + ": ";
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Manager.planComplete()) {
            while (!Manager.allCustomersCameOut()) { // this condition is necessary that cashiers don't close while customers in shop
                Buyer buyer = QueueBuyers.extract();
                if (buyer != null) {
                    System.out.println(this + " start to service a buyer");
                    int timeout = Helper.getRandom(2000, 5000);
                    Helper.sleep(timeout);
                    double billAmount = 0;
                    Iterator<Map.Entry<String, Double>> cashBox = buyer.provideChosenGoodsToCashier(buyer.chooseGoods()).entrySet().iterator();
                    while (cashBox.hasNext()) {
                        Map.Entry<String, Double> pair = cashBox.next();
                        String product = pair.getKey();
                        double price = pair.getValue();
                        billAmount += price;
                        System.out.println("\t" + this + " : line :" + product + " price : " + price + "BYN");
                    }
                    System.out.println("\t" + this + " says: Total price: " + billAmount + "BYN");
                    synchronized (MONITOR2){
                        TotalSum = TotalSum+billAmount;
                    }
                    System.out.println("\t" + this + " finished to service a buyer");

                    synchronized (buyer) {
                        buyer.notify();
                        System.out.flush();
                    }

                } else {
                    Helper.sleep(1000);

                }
            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
