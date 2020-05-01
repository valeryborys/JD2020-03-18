package by.it.okatov.jd02_03;

class Cashier implements Runnable {

    String name;
    private int number;

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    Cashier(int number) {
        setNumber(number);
        name = "\tCashier #" + getNumber() + ":";
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Manager.planComplete()) {
            Buyer buyer = BuyersQueue.extract();
            if (buyer != null) {
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
}






























