package by.it.okatov.jd02_02;

class Cashier implements Runnable {

    private final String name;

    Cashier(int number) {
        name = "\tCashier # " + number;
    }

    @Override
    public void run() {
        System.out.println(this + " Opened");
        while (!Manager.planComplete()) {
            Buyer extract = BuyersQueue.extract();
            if (extract != null) {
                System.out.println(this + " begins to service " + extract);
                int t = Utils.getRandom(2, 5);
                Utils.waitForSeconds(t);
                System.out.println(this + " finishes servicing " + extract);
            } else {
                Utils.waitForSeconds(1);
            }
        }

        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}


















