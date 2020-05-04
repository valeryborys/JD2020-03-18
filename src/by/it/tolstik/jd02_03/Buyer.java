package by.it.tolstik.jd02_03;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner;
    private boolean waitState = false;

    public void setWaitState(boolean waitState) {
        this.waitState = waitState;
    }

    public Buyer(int number) {
        super("Buyer № " + number + " ");
        Manager.buyerEnterToShop(); //зашел покупатель (счетчик ++)
    }

    @Override
    public void run() {
        enterToMarket(); //вошел в магазин
        chooseGoods(); //взял корзину, начал выбирать товары, положил товары в корзину, завершил выбирать товары
        goToQueue();
        goOut(); //вышел из магазина

    }

    @Override
    public void enterToMarket() {
        if (isPensioner()) System.out.println(this + "вошел в магазин, он пенсионер");
        else System.out.println(this + "вошел в магазин");
        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        takeBacket(); //взял корзину
        System.out.println(this + "начал выбирать товары"); //начал выбирать товары
        int timeout;
        if (pensioner) timeout = (int) (Helper.getRandom(500, 2000) * Manager.K_FOR_OLDER_PEOPLE);//коэф пенсионера
        else timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout, 100);
        putGoodsToBacket(); //положил товары в корзину
        if (pensioner) System.out.println(this + "завершил выбирать товары, он пенсионер");
        else System.out.println(this + "завершил выбирать товары"); //завершил выбирать товары
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            QueueBuyers.add(this);
            waitState = true;
            while (waitState) {
                try {
                    System.out.println(this + "стал в очередь");
                    Manager.addQueueValue();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t" + Manager.getQueueValue());
                    this.wait(); //ждем notify();
                    System.out.println(this + "покинул очередь");
                    Manager.buyerQuiteShop(); //вышел покупатель (счетчик ++)
                    Manager.leaveQueueValue();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t" + Manager.getQueueValue());
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted" + Thread.currentThread(), e);
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public boolean isPensioner() {
        int flag = Helper.getRandom(1, 4);
        if (flag == 1) pensioner = true;
        return pensioner;
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "взял корзину");
    }

    @Override
    public int putGoodsToBacket() {
        int timeout;
        if (pensioner) timeout = (int) (Helper.getRandom(500, 2000) * Manager.K_FOR_OLDER_PEOPLE);//коэф пенсионера
        else timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout,10);
        //загрузка в тележку рандомных продуктов из Goods
        int count = Helper.getRandom(1, 4);
        int sum = 0; //инициализация суммы чека
        for (int i = 0; i < count; i++) {
            int value = Helper.getRandom(1, Goods.goodsList().size() - 1);
            System.out.println(this + "положил в корзину " + Goods.getGoodsName().get(value)
                    + " за " + Goods.getGoodsPrice().get(value) + " рублей.");
            sum += Goods.getGoodsPrice().get(value);
        }
        return sum;
    }

    @Override
    public String toString() {
        return getName();
    }
}
