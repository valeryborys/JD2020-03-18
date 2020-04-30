package by.it.verbitsky.jd02_03;

class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.setBuyersPlan(10); //default 100
        shop.setCashierLimit(5);//default 5
        shop.setQueueCapacity(30);//default 30
        Thread thread = new Thread(shop);
        thread.start();
        /*
         *shop can be initialized:
         * new Shop (int shopPlan, int cashierLimit, int queueCapacity)
         */

    }
}
