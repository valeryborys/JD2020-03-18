package by.it.borys.jd02_02;

public class Cashier implements Runnable {
private String name;
    Cashier(int number) {
        name = "\tCashier №"+number+": ";
    }

    @Override
    public void run() {
        System.out.println(this +" opened");
        while (!Manager.planComplete()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer!=null){
                System.out.println(this+" start to service "+buyer);
                int timeout = Helper.getRandom(2000,5000);
                Helper.sleep(timeout);
                synchronized (buyer){
                buyer.notify();
                System.out.flush();}
                System.out.println(this+" finished to service "+buyer);
            }
            else Helper.sleep(100);//TODO сделать что бы кассир засыпал/просыпался
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
