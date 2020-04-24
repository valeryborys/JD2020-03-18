package by.it.okatov.jd02_02;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private static boolean isElder;
    private static final float ELDERY_COEF = 1.5f;

    static boolean isElder() {
        return isElder;
    }

    static void setEldery(boolean eldery) {
        isElder = eldery;
    }

    Buyer(int num) {
        super(String.format("Buyer #%d ", num));
        Manager.addBuyer();
    }

    Buyer(int num, boolean isElder) {
        super(String.format("Buyer (pensioneer) #%d ", num));
        setEldery(true);
        Manager.addBuyer();
    }


    @Override
    public void run() {
        enterToMarket(); //Войти в магазин
        takeCart(); //Взять тележку
        chooseGoods(); //Выбрать товары
        putGoodsToCart(); //Положить товары в корзину
        goToQueue();
        goOut();//Уйти из магазина (разумеется, не заплатив ХDDD)
    }

    @Override
    public void enterToMarket() {
        Utils.threads.add(this);
        System.out.println(this + "enters the supermarket");
        Utils.GLOBAL_COUNTER++;//Увеличиваем счетчик покупателей
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "starts to collect goods");
        int timeout = Utils.getRandom(1, 3);
        if (isElder()) {//Если пенсионер
            Utils.waitForSeconds(timeout * ELDERY_COEF);
        } else {
            Utils.waitForSeconds(timeout);
        }


        System.out.println(this + "finishes collecting goods");

    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            BuyersQueue.add(this);
            try {
                System.out.println(this + " added to queue");
                wait();
                System.out.println(this + " leaves queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void goOut() {

        Utils.GLOBAL_COUNTER--;//Уменьшаем количество покупателей
        System.out.println(this + "returns a cart in the supermarket");
        if (isElder()) {//Было решено, что на выход из магазина тоже нужно время.
            Utils.waitForSeconds(1 * ELDERY_COEF);
        } else {
            Utils.waitForSeconds(1);
        }
        System.out.println(this + "leaves the supermarket");
        Utils.threads.remove(this);
    }

    @Override
    public void takeCart() {
        int timeout = Utils.getRandom(1, 3);
        if (isElder()) {
            Utils.waitForSeconds(timeout * ELDERY_COEF);
        } else {
            Utils.waitForSeconds(timeout);
        }
        System.out.println(this + "takes a cart in the supermarket");
    }

    @Override
    public void putGoodsToCart() {
        int goodsQuant = Utils.getRandom(0, 4);
        int i = 0;
        int timeout = Utils.getRandom(1, 3);

        for (Map.Entry<String, Integer> entry : Utils.gethMap().entrySet()) {
            if (isElder()) {
                Utils.waitForSeconds(timeout * ELDERY_COEF);
            } else {
                Utils.waitForSeconds(timeout);
            }
            if (i >= goodsQuant) {
                break;
            }
            String key = entry.getKey();
            int val = entry.getValue();
            System.out.println(this + "puts " + key + " for $" + val);
            i++;
        }
    }


    @Override
    public String toString() {
        return getName();
    }
}
