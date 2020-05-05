package by.it.bobrovich.jd02_02;

class Cashier implements Runnable {
    String name;
    int number;
//    Account account;
//    Income income;

    public Cashier(int number) {
        this.number = number;
        name = "\tCashier" + number + " ";
    }

    @Override
    public void run() {
        addToQueue();
        System.out.println(this + " opened");
        while(!Manager.planComplete()){
            Buyer buyer;
//            System.out.println(QueueBuyers.getQueue());
            if(this.number == 1) {
                buyer = QueuePensioneer.extractPensioneer();
            } else{
                buyer = QueueBuyers.extract();
            }
            if(buyer!=null){
                System.out.println(this + " start to service " + buyer);
                int timeout = Helper.getRandom(2000, 5000);
                Helper.sleep(timeout);
//                account = new Account();
//                income = new Income();
                synchronized (buyer){
                    buyer.notify();
                }
                Helper.sleep(2000);
            } else{
                addToQueue();
            }
        }
//        showIncome();
        Manager.closeCashiers();
        System.out.println(this + " closed");
    }


    /*
    private void showIncome() {
        System.out.println(income.getGoodsCount());
    }

    private void fillIncome(Buyer buyer) {
        for (String listGood : buyer.backet.getListGoods()) {
            income.addGoods(listGood);
        }
    }

    private void fillListGoods(Buyer buyer) {
        for (String listGood : buyer.backet.getListGoods()) {
            account.addToList(listGood, Manager.goods.get(listGood));
        }
    }

    private void showAccountList() {
        System.out.println(account.getList());
    }
*/


    private void addToQueue(){
        synchronized (this){
            System.out.println(this + " waiting");
            QueueCashier.add(this);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
