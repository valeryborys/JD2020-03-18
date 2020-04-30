package by.it.verbitsky.jd02_03;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class NShopManager extends Thread implements CashierStrings {


//    private static final int PLAN = 100;
//    public static final int MAX_CASHIER_COUNT = 5; // максимальное кол-во касс
//    public static final int CASHIER_COUNT_FACTOR = 5; // кол-во покупателей на 1 кассу, при котором надо открывать еще 1

//    private volatile double totalCash = 0;
//  private Set<Cashier> cashiers = new HashSet<>();
//  private List<Buyer> buyers = new ArrayList<>();

/*
    public double getTotalCash() {
        return totalCash;
    }

        public void setTotalCash(double checkSum) {
            synchronized (TOTAL_SUM_MONITOR) {
                this.totalCash += checkSum;
          }
        }

        public int getFreeCashierCount() {
            int count = 0;
            for (Cashier cashier : cashiers) {
                switch (cashier.getState()) {
                    case WAITING: {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }

 /*
    @Override
    public void run() {
        ShopPrinter.printMessage("Start shop manager");
        while (outBuyersCount < PLAN) {

        }

        //все покупатели вышли, проверим что все кассы успели завершить свои потоки и находятся в состоянии WAITING
        //если касса будет в состоянии WAITING, то при запросе статуса от манагера получит команду завершить цикл опроса
        //и поток корректно завершиться

    }
    /*
        private void printFinishBlock() {
            ShopPrinter.printMessage("\n\nAll buyers are served");
            ShopPrinter.printMessage("\nTotal cash = " + String.format("%6.2f", getTotalCash()));
            ShopPrinter.printMessage("\nAll cashiers are stopped:");
            ShopPrinter.printMessage(getCashiersStatus());
            ShopPrinter.printMessage("Possible to ose the shop");
        }
    /*
        private void stopCashiersThreads() {
            int stopCount = 1;
            while (stopCount > 0) {
                stopCount = 0;
                for (Cashier cashier : cashiers) {
                    switch (cashier.getState()) {
                        case WAITING:
                        case RUNNABLE:
                        case BLOCKED:
                        case TIMED_WAITING: {
                            stopCount++;
                            break;
                        }
                    }
                }
                notifyAllCashiers();
                ShopPrinter.printMessage("Waiting until cashiers finish ...");
            }
        }

        private void notifyAllCashiers() {
            for (Cashier cashier : cashiers) {
                synchronized (cashier) {
                    cashier.notify();
                }
            }
        }

        private String getCashiersStatus() {
            StringBuilder status = new StringBuilder();
            for (Cashier cashier : getCashiers()) {
                status.append(cashier.getName()).append(" ").append(cashier.getState().toString()).append("\n");
            }
            return status.toString();
        }

        public void printCashiersStatus() {
            StringBuilder text = new StringBuilder();
            for (Cashier cashier : cashiers) {
                text
                        .append(cashier.getName())
                        .append(" ")
                        .append(cashier.getState())
                        .append("\n");

            }
            ShopPrinter.printMessage(text.toString());
        }

    public void addBuyer(Buyer buyer) {
        synchronized (BUYER_MONITOR) {
            buyers.add(buyer);
            inBuyerCount++;
        }
    }

    public void removeBuyer(Buyer buyer) {
        synchronized (BUYER_MONITOR) {
            buyers.remove(buyer);
            outBuyersCount++;
        }
    }
    */
/*
    public boolean getStatusForCashier() {
        return outBuyersCount != PLAN;
    }

    public static int getOutBuyersCount() {
        return outBuyersCount;
    }

    public int getCurrentBuyersCount() {
        return inBuyerCount - outBuyersCount;
    }

    static boolean planCompleted() {
        return PLAN == outBuyersCount;
    }

    static boolean isShopOpen() {
        return inBuyerCount == PLAN;
    }
/*
    public Set<Cashier> getCashiers() {
        return cashiers;
    }

    public static Object getCashierMonitor() {
        return CASHIER_MONITOR;
    }
*/

    private Shop shop;

    private static final int BUYER_COUNT_FACTOR = 5; //коэффициент, при котором нужно увеличивать кол-во кассиров

    private ExecutorService cashierPool;

    //private volatile static int inBuyerCount = 0;

    private Set<NCashier> cashiersSet = new HashSet<>();

    private AtomicInteger outBuyersCount;

    private AtomicInteger inBuyersCount;

    private AtomicReference<Double> totalCash;

    public NShopManager(Shop shop) {
        this.shop = shop;//ссылка на магазин чтобы получать инфо о покупателях и очереди
        this.cashierPool = Executors.newFixedThreadPool(shop.getCashierLimit());//создаем пул для кассиров
        this.outBuyersCount = new AtomicInteger(0); //хранит кол-во вышедших(обслуженых) покупателей
        this.inBuyersCount = new AtomicInteger(0); //хранит кол-во вошедших покупателей
        this.totalCash = new AtomicReference<>((double) 0);
    }


    @Override
    public void run() {
        //ShopPrinter.printMessage("Start shop manager");
        System.out.println("start create cashiers");
        createCashiers();
        System.out.println("end create cashiers");
        while (outBuyersCount.get() < shop.getBuyersPlan()) {
            //проверяем есть ли очередь и сколько в ней человек
            //и надо ли запускать еще 1 кассира
            if (shop.getQueueManager().getQueueSize() > (shop.getCashierLimit() - getFreeCashiersCount()) * BUYER_COUNT_FACTOR) {
                NCashier free = getFreeCashier();
                if (free != null) {
                    cashierPool.execute(free);
                } else {
                    System.out.println("All cashiers is busy now");
                }
            }
        }
        cashierPool.shutdown();
        try {
            while (!cashierPool.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\n\nРабота кассиров окончена");
        System.out.println("Все покупатели обслужены, можно закрывтаь магазин");
    }

    private int getFreeCashiersCount() {
        int count = 0;
        for (NCashier cashier : cashiersSet) {
            if (!cashier.isActive()) {
                count++;
            }
        }
        return count;
    }

    private NCashier getFreeCashier() {
        for (NCashier cashier : cashiersSet) {
            if (!cashier.isActive()) {
                return cashier;
            }
        }
        return null;
    }

    private void createCashiers() {
        for (int i = 0; i < shop.getCashierLimit(); i++) {
            cashiersSet.add(new NCashier(shop, ("Cashier-" + (1 + i))));
        }
    }

    public void buyerServed() {
        outBuyersCount.getAndIncrement();
        System.out.printf("Размер очереди: %s, свободных касс: %d\n",
                shop.getQueueManager().getQueueSize(),
                getFreeCashiersCount());
    }

    public void buyerComeIn() {
        inBuyersCount.getAndIncrement();
    }


    public boolean getStatusForCashier() {
        return (shop.getQueueManager().getQueueSize() >
                (shop.getCashierLimit() - getFreeCashiersCount()) * BUYER_COUNT_FACTOR);
    }

    @Override
    public String toString() {
        return "ShopManager:";
    }

    public boolean isShopOpen() {
        return shop.getBuyersPlan() == inBuyersCount.get();
    }

    public int getCurrentBuyersCount() {
        return inBuyersCount.get() - outBuyersCount.get();
    }

    public double getTotalCash() {
        return totalCash.get();
    }

    public void setTotalCash(double totalCash) {
        this.totalCash.getAndSet(totalCash);
    }
}
