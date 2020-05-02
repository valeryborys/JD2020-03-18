package by.it.tolstik.jd02_02;

class Cashier implements Runnable {

    private final String name;

    Cashier(int number) {
        name = "\tCashier # " + number + ": ";

    }

    @Override
    public void run() {

        goToQueue();
        System.out.println(this + "открылся");

        while (!Manager.planComplete()) {
            Buyer extractBuyer = QueueBuyers.extract();
            if (extractBuyer != null) {
                System.out.println(this + "начинает обслуживать " + extractBuyer);
                int random = Helper.getRandom(2000, 5000);
                Helper.sleep(random, 1000);
                System.out.println("\tCумма чека " + extractBuyer + ": " + extractBuyer.putGoodsToBacket() + " рублей.");
                System.out.println(this + "закончил обслуживать " + extractBuyer);
                Manager.addToTotalSum(extractBuyer.putGoodsToBacket());
                synchronized (extractBuyer) {
                    extractBuyer.notify();
                    System.out.flush();
                }
            } else {
                Helper.sleep(100); //добавить wait();
            }
        }

        System.out.println(this + "закрылся");
    }

    public void goToQueue() {
        synchronized (this) {
            QueueCashiers.add(this);
            try {
                wait(); //ждем notify();
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
