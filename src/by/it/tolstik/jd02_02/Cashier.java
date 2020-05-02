package by.it.tolstik.jd02_02;

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
            Buyer extractBuyer = QueueBuyers.extract();
            if (extractBuyer != null) {

                System.out.println(this + "начинает обслуживать " + extractBuyer);
                int random = Helper.getRandom(2000, 5000);
                Helper.sleep(random);
                System.out.println("\tCумма чека " + extractBuyer + ": " + extractBuyer.putGoodsToBacket() + " рублей.");
                System.out.println(this + "закончил обслуживать " + extractBuyer);
                Manager.addToTotalSum(extractBuyer.putGoodsToBacket());
                synchronized (extractBuyer) {
                    extractBuyer.notify();
                    System.out.flush();
                }
            } //else что б кассир засыпал
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
