package by.it.szamostyanin.jd02_02;

public class Cashier implements Runnable {

    private String name;


    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + "== Opened ==");
        while (!Manager.planComplete()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " begin to service " + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                synchronized (buyer){
                    buyer.notify();
                }
                System.out.println(this + " finished to service " + buyer);
            } else {
                Helper.sleep(100);
            }
        }
        System.out.println(this + "== Closed ==");
    }

    @Override
    public String toString() {
        return name;
    }
}
