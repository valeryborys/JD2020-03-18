package by.it.verbitsky.jd02_02;

import java.util.Locale;

class Cashier extends Thread implements CashierStrings {
    private String name;

    public Cashier(int number) {
        super("Cashier" + number);
        this.name = "Cashier" + number;
    }

    @Override
    public String toString() {
        return this.name + ": ";
    }

    @Override
    public void run() {
        System.out.println("Касса " + this + " открылась \n");
        boolean needWork = true;
        //при старте потока касса начинает запрашивать у шоп манагера статус для работы
        //WORK - обслужить покупателя
        //SLEEP - приостановить поток и ждать notify от манагера
        //END - выйдет из цикла, и поток завершиться
        while (needWork) {
            switch (Shop.getShopManager().getStatusForCashier()) {
                case CashierStrings.END: {
                    System.out.println(this.name + " получила статус END");
                    needWork = false;
                    break;
                }
                case CashierStrings.WORK: {
                    System.out.println(this.name + " получила статус WORK");
                    Buyer buyer = ShopQueue.extract();
                    if (buyer != null) {
                        service(buyer);
                    }
                    break;
                }
                case CashierStrings.SLEEP: {
                    try {
                        System.out.println(this.name + " получила статус SLEEP (касса временна остановлена) ");
                        synchronized (this) {
                            Shop.getShopManager().sleepCashier();
                            wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println("касса " + this + " завершила работу");
    }

    private void service(Buyer buyer) {
        System.out.println(this.name + " начал обслуживать покупателя " + buyer + "\n");
        //имитация обслуживания покупателя, задержки пока уменьшены
        Helper.sleep(Helper.getRandomTimeout(2000, 5000, buyer.getSpeedFactor()));
        //печатаем чек покупателя
        printBuyerInvoice(buyer);
        System.out.println("\n" + this.name + " закончил обслуживать покупателя " + buyer + "\n");
        //посылаем потоку покупателя сигнал "проснуться" и очищаем консоль если она вдруг была чем то занята
        synchronized (buyer) {
            buyer.notify(); //говорим покупателю что он может уходить
            System.out.flush();
        }
    }


    private void printBuyerInvoice(Buyer buyer) {
        Invoice invoice = getInvoice(buyer);
        System.out.printf(Locale.ENGLISH,
                "\nЧек покупателя: %s, Всего товаров на сумму: %3.2f\n",
                invoice.goods,
                invoice.totalPrice);
    }

    private Invoice getInvoice(Buyer buyer) {
        int totalPrice = 0;
        StringBuilder buyerGoods = new StringBuilder();
        for (Good good : buyer.getBacket().getGoodList()) {
            totalPrice += good.getPrice();
            buyerGoods
                    .append(good.getName())
                    .append(" цена: ")
                    .append(Math.round(good.getPrice() * 100) / 100.0)
                    .append(" ");


        }
        return new Invoice(buyerGoods.toString(), totalPrice);
    }

}
