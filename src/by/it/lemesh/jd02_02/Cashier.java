package by.it.lemesh.jd02_02;

import java.util.Map;

class Cashier implements Runnable {
    private String name;
    private int number;
    static final Object MONITOR_CASHIER = new Object();

    public Cashier(int number) {
        name = "\tCashier # " + number + ": ";
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " is open");
        while (!Manager.planComplete()) {
            if (Manager.needToClose()) {
                synchronized (this) {
                    QueueCashiers.addCashierToQueue(this);
                    try {
                        System.out.println(this + " is closed");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            Buyer extract = QueueBuyers.extract();
            if (extract != null) {
                System.out.println(extract + " left the queue");
                synchronized (System.out) {
                    System.out.println(this + " Cashier started serving " + extract);
                    String tab1 = Helper.getTab1(this.number);
                    String tab2 = Helper.getTab2(this.number);
                    System.out.println(tab1 + "Bill " + extract);
                    int total = 0;
                    for (Map.Entry<String, Integer> entry : extract.goods.entrySet()) {
                        System.out.printf(tab1 + "%-16s%4d\n", entry.getKey(), entry.getValue());
                        total += entry.getValue();
                    }
                    System.out.printf(tab1 + "%16s%4d" + tab2 + "%20d%20d\n", "Total: ", total, QueueBuyers.getLength(), Manager.cashReport(total));
                }
                int timeOut = Helper.getRandom(2000, 5000);
                Helper.sleep(timeOut);
                System.out.println(this + " Cashier finished serving " + extract);
                synchronized (extract) {
                    extract.notify();
                    System.out.flush();
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
