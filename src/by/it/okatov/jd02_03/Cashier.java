package by.it.okatov.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Cashier implements Runnable {

    String name;
    private final AtomicInteger number = new AtomicInteger(0);
    private boolean isActive = false;

    public void setActive(boolean active) {
        isActive = active;
    }

    int getNumber() {
        return number.get();
    }

    void setNumber(int number) {
        this.number.set(number);
    }

    Cashier(int number) {

        setNumber(number);
        name = "\tCashier #" + getNumber() + ":";
        //deactivate();
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        if (!isActive) {
            try {
                synchronized (this) {
                    System.out.println(this + " завершил работу из-за недостатка посетителей!");
                    wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!Manager.planComplete()) {
            Buyer buyer = BuyersQueue.extract();
            if (buyer != null && isActive) {
                System.out.println("Статус " + this + " активен: " + isActive);
                System.out.println(this + " begins servicing " + buyer);
                int t = Utils.getRandom(2, 5);
                Utils.waitForSeconds(t);
                System.out.println(this + " has finished servicing " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                    System.out.flush();
                }
            } else {
                Utils.waitForSeconds(0.1f);
            }
        }
        System.out.println(this + " closed");
    }

    void deactivate() {
        if (this.isActive) {
            System.out.println(this + " завершил работу из-за недостатка посетителей!");
            //this.wait();
            setActive(false);
        }

    }

    synchronized void setActive() {
        if (!this.isActive) {

            System.out.println("//------------------------Количество покупателей: " + Utils.GLOBAL_COUNTER.get());
            System.out.println(this + " начал работу из-за наплыва посетителей!");
            this.setActive(true);
            this.notify();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}






























