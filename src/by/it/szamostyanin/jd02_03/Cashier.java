package by.it.szamostyanin.jd02_03;

public class Cashier implements Runnable {

    private String name;


    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " - Opened");
        while (!Manager.planComplete()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println("\t" + this + " begin to service " + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                System.out.println("\t" + this + " finished to service " + buyer);
                synchronized (buyer) {
                    buyer.setWaitState(false);  //переводим в состояние - ожидание завершено и посылаем notify, что бы исключить notifyAll и обеспечить корректное завершение своего ожидание
                    buyer.notify();
                    System.out.flush(); //очиска консоли
                }
            } else {
                Helper.sleep(100);  //подумать как сделать корректнее
            }
        }
        System.out.println(this + " - Closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
