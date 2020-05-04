package by.it.tolstik.jd02_03;

class Cashier implements Runnable {

    private final String name;
    private boolean needOpened = true;
    private static int cashiersOpened = 0;

    Cashier(int number) {
        name = "\tCashier # " + number + ": ";
    }

    @Override
    public void run() {

        System.out.println(this + "открылся");
        cashiersOpened++;
        while (!Manager.planComplete() && needOpened) {
            if (QueueBuyers.dequeForPensioner.size() != 0) {
                Buyer extractPens = QueueBuyers.extractPens();
                if (extractPens != null) {
                    System.out.println(this + "начинает обслуживать " + extractPens + ". Он напомню пенсионер.");
                    int random = Helper.getRandom(2000, 5000);
                    Helper.sleep(random, 10);
                    System.out.println("\tCумма чека " + extractPens + ": " + extractPens.putGoodsToBacket() + " рублей.");
                    System.out.println(this + "закончил обслуживать " + extractPens);
                    Manager.addToTotalSum(extractPens.putGoodsToBacket());
                    synchronized (extractPens) {
                        extractPens.notify();
                        System.out.flush();
                    }
                }
            } else {
                Buyer extractBuyer = QueueBuyers.extract();
                if (extractBuyer != null) {
                    System.out.println(this + "начинает обслуживать " + extractBuyer);
                    int random = Helper.getRandom(2000, 5000);
                    Helper.sleep(random, 10);
                    System.out.println("\tCумма чека " + extractBuyer + ": " + extractBuyer.putGoodsToBacket() + " рублей.");
                    System.out.println(this + "закончил обслуживать " + extractBuyer);
                    Manager.addToTotalSum(extractBuyer.putGoodsToBacket());
                    synchronized (extractBuyer) {
                        extractBuyer.notify();
                        System.out.flush();
                    }
                }
            }
            synchronized (QueueBuyers.MONITOR) {
                if (cashiersOpened > QueueBuyers.getCashNeed()) needOpened = false;
            }
        }
        System.out.println(this + "закрылся");
        cashiersOpened--;
    }

    public static int getCashiersOpened() {
        return cashiersOpened;
    }

    @Override
    public String toString() {
        return name;
    }
}
