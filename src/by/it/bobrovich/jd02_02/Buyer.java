package by.it.bobrovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean isPensioneer;
    Backet backet;

    public Buyer(int number, boolean isPensioneer) {
        super("Buyer №" + number + " " + isPensioneer + " ");
        this.isPensioneer = isPensioneer;
        Manager.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        breakTime(this.isPensioneer);
        backet = takeBacket();
        breakTime(this.isPensioneer);
        chooseGoods();
        breakTime(this.isPensioneer);
        putGoodsToBacket(backet);
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the shop");
    }

    @Override
    public Backet takeBacket() {
        System.out.println(this + "take backet");
        return new Backet();
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "start to choose goods");
        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void putGoodsToBacket(Backet backet) {
        List<String> listGoods = new ArrayList<>(Manager.goods.keySet());
        int count = Helper.getRandom(0, 4);
        for (int i = 0; i < count; i++) {
            int count1 = Helper.getRandom(0, 3);
            backet.addGoods(listGoods.get(count1));
        }
        for (String listGood : backet.getListGoods()) {
            System.out.println(this + "take " + listGood + " " + Manager.goods.get(listGood));
        }
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            if (this.isPensioneer) {
                QueuePensioneer.addPensioneer(this);
            }else{
                QueueBuyers.add(this);
            }
            try {
                System.out.println(this + " added to queue");
                wait();
                System.out.println(this + " leave the queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void goOut() {
        System.out.println(this + "leave the shop");
        Manager.leaveBuyer();
    }

    public void breakTime(boolean isPensioneer) {
        int timeout;
        if (isPensioneer)
            timeout = Helper.getRandom(750, 3000);
        else
            timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
    }

    @Override
    public String toString() {
        return getName();
    }
}
