package by.it.tolstik.jd02_02;

class Cashier implements Runnable{

    private String name;

    Cashier(int number){
        name = "\tCashier # " + number + ": ";

    }
    @Override
    public void run() {
        System.out.println(this + "открылся");
        while (!Manager.planComplete()) {
            Buyer extract = QueueBuyers.extract();
            if (extract != null) {
                System.out.println(this + "начинает обслуживать " + extract);
                int random = Helper.getRandom(2000, 5000);
                Helper.sleep(random,100);
                System.out.println(this + "закончил обслуживать " + extract);
                synchronized (extract) {
                    extract.notify();
                    System.out.flush();
                }
            } else {
                Helper.sleep(100);
            }
        }

        System.out.println(this + "закрылся");
    }

    @Override
    public String toString() {
        return name;
    }
}
