package by.it.verbitsky.jd02_03;

class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.setBuyersPlan(100); //default 100 total count of buyers
        shop.setCashierLimit(5);//default 5 max cashiers count
        shop.setQueueCapacity(30);//default 30 max shopqueue length
        shop.setBasketCount (50);//default 50 count of baskets in the shop
        shop.setSynchronousChooseCount (20); //default 20 one-time number of buyers choosing a product
        Thread thread = new Thread(shop);
        thread.start();
        /*
         *shop can be initialized:
         * new Shop (int shopPlan, int cashierLimit, int queueCapacity, int basketCount)
         */

    }
}
