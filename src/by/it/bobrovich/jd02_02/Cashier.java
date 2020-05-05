package by.it.bobrovich.jd02_02;

class Cashier implements Runnable {
    String name;


    public Cashier(int number) {
        name = "\tCashier" + number + " ";
    }

    @Override
    public void run() {
        addToQueue();
        System.out.println(this + " opened");
        while(!Manager.planComplete()){
            System.out.println(QueueBuyers.getQueue());
            Buyer buyer = QueueBuyers.extract();
            if(buyer!=null){
                System.out.println(this + " start to service " + buyer);
                int timeout = Helper.getRandom(2000, 5000);
                Helper.sleep(timeout);
                synchronized (buyer){
                    buyer.notify();
                }
                Helper.sleep(2000);
            } else{
                addToQueue();
            }
        }
        Manager.closeCashiers();
        System.out.println(this + " closed");
    }

    private void addToQueue(){
        synchronized (this){
            System.out.println(this + " waiting");
            QueueCashier.add(this);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
