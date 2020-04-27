package by.it.verbitsky.jd02_02;

class Cashier extends Thread implements CashierStrings {
    private String name;
    private int cashierId;

    public int getCashierId() {
        return cashierId;
    }

    public Cashier(int number) {
        super("Cashier" + number);
        this.name = "Cashier" + number;
        this.cashierId = number;
    }

    @Override
    public String toString() {
        return this.name + ": ";
    }

    @Override
    public void run() {
        ShopPrinter.printMessage("Касса " + this + " открылась \n");
        boolean needWork = true;
        //работает пока есть кто-то в очереди
        //за кол-вом необходимых касс следим манагер
        while (needWork) {
            Buyer buyer = ShopQueue.extract();
            while (buyer != null) {
                service(buyer);
                ShopPrinter.printMessage("Free Cashes count: " + Shop.getShopManager().getFreeCashierCount());
                ShopPrinter.printMessage("Queue size now: " + ShopQueue.getQueueCount());
                buyer = ShopQueue.extract();
            }
            try {
                synchronized (this) {
                    ShopPrinter.printMessage(this.name + " temporary put on hold");
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            needWork = Shop.getShopManager().getStatusForCashier();
        }
        ShopPrinter.printMessage(this + " finish work");
    }

    private void service(Buyer buyer) {
        ShopPrinter.printMessage(this.name + " begin service " + buyer + "\n");
        //имитация обслуживания покупателя, задержки пока уменьшены
        Helper.sleep(Helper.getRandomTimeout(2000, 5000, buyer.getSpeedFactor()));
        //печатаем чек покупателя
        ShopPrinter.printCheck(this, buyer);
        ShopPrinter.printMessage("\n" + this.name + " finish service " + buyer + "\n");
        //посылаем потоку покупателя сигнал "проснуться" и очищаем консоль если она вдруг была чем то занята
        synchronized (buyer) {
            buyer.notify(); //говорим покупателю что он может уходить
            //System.out.flush();
        }
    }
}
