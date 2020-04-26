package by.it.gutkovsky.jd02_02;

class Cashier implements Runnable{
    private String name;

    Cashier(int number) {
        this.name = "\tCashier № "+ number+": ";
    }

    @Override
    public void run() {
        System.out.println(this +  " opened");
        while (!Manager.planComplete()) {
            Buyer buyer = QueueBuyers.extract();
            if(buyer != null){
                System.out.println(this + " start to service a buyer");
                int timeout = Helper.getRandom(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this + " finished to service a buyer");
                synchronized (buyer){
                    buyer.notify();
                    System.out.flush();
                }

            } else {
                Helper.sleep(100);

            }
        }

        System.out.println(this + " closed");

    }

    @Override
    public String toString() {
        return name;
    }
}
