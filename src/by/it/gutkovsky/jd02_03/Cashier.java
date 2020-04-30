package by.it.gutkovsky.jd02_03;

import java.util.Iterator;
import java.util.Map;

class Cashier implements Runnable {
    private final String name;
    private final int number;
    static final Object MONITOR2 = new Object();

    private static volatile double totalSum = 0;

    public static double getTotalSum() {
        return totalSum;
    }


    Cashier(int number) {
        name = "\tCashier № " + number + ": ";
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Manager.planComplete()) {
            while (!Manager.allCustomersCameOut()) { // this condition is necessary that cashiers don't close while customers in shop
            if (Manager.closeCashier()){
                synchronized (this){
                    QueueCashier.addStaff(this);
                    System.out.println(this + " closing for the rest");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new  RuntimeException(e);
                    }
                }
            }




//            while (!Manager.allCustomersCameOut()) { // this condition is necessary that cashiers don't close while customers in shop
                Buyer buyer = QueueBuyers.extract();
                if (buyer != null) {
                    double billAmount;
                    synchronized (System.out) {
                        billAmount = getBillAmount(buyer);
                    }
                    synchronized (MONITOR2) {
                        totalSum = totalSum + billAmount;
                    }
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

    private double getBillAmount(Buyer buyer) {
        int timeout = Helper.getRandom(2000, 5000);
        Helper.sleep(timeout);
        System.out.println(this + " start to service a buyer - " + buyer.getName());
        double billAmount = 0;
        Iterator<Map.Entry<String, Double>> cashBox = buyer.getBasket().getBasketList().entrySet().iterator();
        printTopRow();
        while (cashBox.hasNext()) {
            Map.Entry<String, Double> pair = cashBox.next();
            String product = pair.getKey();
            double price = pair.getValue();
            billAmount += price;
            System.out.println(printBillFormat() + product + "-" + price + "BYN");
        }
        System.out.println(printBillFormat() + "Sum: " + billAmount + "BYN");
        System.out.printf("%-110s%-3d%-19s%6.2f\n", " ", QueueBuyers.queueSize(), " ", (totalSum + billAmount));
//        System.out.println("\t" + this + " says: Total price: " + billAmount + "BYN");
        System.out.println(this + " finished to service a buyer");
//        System.out.println("\t\tCurrent revenue in shop:" + totalSum + "BYN");
        System.out.flush();
        return billAmount;
    }

    private void printTopRow() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", "Cashier №1", "Cashier №2", "Cashier №3", "Cashier №4", "Cashier №5", "Queue size", "Total sum");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private String printBillFormat() {
        String billFormat = "";

        switch (this.number) {
            case 1:
                billFormat = "";
                break;
            case 2:
                System.out.printf("%-22s", " ");
                break;
            case 3:
                System.out.printf("%-44s", " ");
                break;
            case 4:
                System.out.printf("%-66s", " ");
                break;
            case 5:
                System.out.printf("%-88s", " ");
                break;
        }
        return billFormat;
    }
}
