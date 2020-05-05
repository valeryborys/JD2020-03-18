package by.it.verbitsky.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class ShopQueue {
    //очередь обычных покупателей
    private BlockingDeque<Buyer> shopQueue;
    //отдельная очередь для пенсионеров,
    private BlockingDeque<Buyer> shopPensionerQueue;


    public ShopQueue(int capacity) {
        shopPensionerQueue = new LinkedBlockingDeque<>(capacity);
        shopQueue = new LinkedBlockingDeque<>(capacity);
    }

    //добавляет покупателя в очередь
    protected boolean add(Buyer buyer) {
        if (buyer.isPensioner()) {
            return this.shopPensionerQueue.offerLast(buyer);
        }
        return this.shopPensionerQueue.offerLast(buyer);
    }

    //извлекает покупателя из очереди
    protected Buyer extract() {
        if (this.shopPensionerQueue.size() > 0) {
            return this.shopPensionerQueue.pollFirst();
        }
        return this.shopQueue.pollFirst();
    }

    protected int getShopQueueSize() {
        return shopQueue.size() + shopPensionerQueue.size();
    }
}
