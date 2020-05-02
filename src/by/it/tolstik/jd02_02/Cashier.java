package by.it.tolstik.jd02_02;

class Cashier implements Runnable{

    private final String name;

    Cashier(int number){
        name = "\tCashier # " + number + ": ";

    }
    @Override
    public void run() {


        System.out.println(this + "открылся");

        while (!Manager.planComplete()) {
            Buyer extractBuyer = QueueBuyers.extract();
            if (extractBuyer != null) {
                System.out.println(this + "начинает обслуживать " + extractBuyer);
                int random = Helper.getRandom(2000, 5000);
                Helper.sleep(random,1000);
                System.out.println("\tCумма чека " + extractBuyer + ": " + extractBuyer.putGoodsToBacket() + " рублей.");
                System.out.println(this + "закончил обслуживать " + extractBuyer);
                synchronized (extractBuyer) {
                    extractBuyer.notify();
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
