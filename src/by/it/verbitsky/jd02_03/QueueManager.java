package by.it.verbitsky.jd02_03;

class QueueManager {
    private ShopQueue shopQueue;
    private Shop shop;

    public QueueManager(Shop shop) {
        shopQueue = new ShopQueue(shop.getQueueCapacity());
        this.shop = shop;
    }

    protected boolean lineUp(Buyer buyer) {
        if (shopQueue.getShopQueueSize() <= shop.getQueueCapacity()) {
            return shopQueue.add(buyer);
        } else {
            return false;
        }
    }

    protected Buyer extractBuyer() {
        return shopQueue.extract();
    }

    protected int getQueueSize() {
        return shopQueue.getShopQueueSize();
    }

}
