package by.it.verbitsky.jd02_02;

import java.util.ArrayList;
import java.util.List;

class ShopManager {
    private List<Buyer> buyers = new ArrayList<>();

    public ShopManager() {
    }

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    public void removeBuyer(Buyer buyer) {
        buyers.remove(buyer);
    }


    public List<Buyer> getBuyers() {
        return buyers;
    }
}
