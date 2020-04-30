package by.it.verbitsky.jd02_03;

class NCashier implements Runnable, CashierStrings {
    private String name;
    private Shop shop;
    private boolean active;
    private int cashierId;

    public NCashier(Shop shop, String name) {
        this.shop = shop;
        this.name = name;
        this.active = false;
        System.out.println("Касса " + this.name + " создана");
    }

    @Override
    public String toString() {
        return this.name + ": ";
    }

    @Override
    public void run() {
        boolean needWork = true;
        this.active = true;
        //работает пока есть кто-то в очереди
        //за кол-вом необходимых касс следим манагер

        //можно убрать внутренний цикл. из задания не совсем понятно, когда именно должна закрываться касса
        //если она открылась в помощь уже работающим - обслужив 1 покупателя, или пока очередь не опустеет

        while (needWork) {
            Buyer buyer = shop.getQueueManager().extractBuyer();
            while (buyer != null) {
                service(buyer);
                buyer = shop.getQueueManager().extractBuyer();
            }
            needWork = shop.getShopManager().getStatusForCashier();
        }
        this.active = false;
    }

    private void service(Buyer buyer) {
        ShopPrinter.printMessage(this.name + " begin service " + buyer + "\n");
        //имитация обслуживания покупателя, задержки пока уменьшены
        Helper.sleep(Helper.getRandomTimeout(2000, 5000, buyer.getSpeedFactor()));
        //печатаем чек покупателя
        ShopPrinter.printCheck(this, buyer, shop);
        //говорим покупателю что он свободен
        buyer.setWaitState(false);
        ShopPrinter.printMessage("\n" + this.name + " finish service " + buyer + "\n");
    }

    public boolean isActive() {
        return active;
    }

    public int getCashierId() {
        return cashierId;
    }
}
