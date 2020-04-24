package by.it.okatov.jd02_02;

class Cashier implements Runnable {

    private final String name;
    private int counter = 0;

    int getNumberOfServed() {
        return counter;
    }

    void setNumberOfServed(int counter) {
        this.counter = counter;
    }

    Cashier(int number) {
        name = "\tCashier # " + (number + 1);
    }

    @Override
    public void run() {
        System.out.println(this + " Opened");
        while (!Manager.planComplete()) {
            Buyer buyer = BuyersQueue.extract();
            if (buyer != null) {
                System.out.println(this + " begins to service " + buyer);
                int t = Utils.getRandom(2, 5);
                Utils.waitForSeconds(t);
                System.out.println(buyer.printCheck());
                System.out.println(this + " finishes servicing " + buyer);
                counter++;
                synchronized (buyer) {
                    buyer.notify();
                    System.out.flush();
                }

            } else {
                Utils.waitForSeconds(1);
            }
        }
        System.out.println(this + " closed");
        System.out.println("Количество обслуженных покупателей у" + this + " равняется: " + getNumberOfServed());
    }

    @Override
    public String toString() {
        return name;
    }
}


















