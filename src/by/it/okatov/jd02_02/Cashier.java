package by.it.okatov.jd02_02;

import java.util.Map;

class Cashier implements Runnable {

    boolean isActive = false;
    private final String name;
    private int sumOnCashBox = 0;


    public int getSumOnCashBox() {
        return sumOnCashBox;
    }

    public void setSumOnCashBox(int nextSum) {
        this.sumOnCashBox += nextSum;
    }

    private final int cNum;

    Cashier(int number) {
        cNum = number;
        name = "\tCashier № " + (number) + ": ";
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        System.out.println(this + " opened");
        if (!isActive) {
            try {
                synchronized (this) {
                    System.out.println(this + " завершил работу из-за недостатка посетителей!");
                    wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!Manager.planComplete()) {
            Buyer elder = QueueBuyers.extractElder();
            if (elder != null) {
                System.out.println(this + " begin to service " + elder);
                int t = Utils.getRandom(1, 5);
                Utils.waitForSeconds(t);

                System.out.println(this + " finished to service " + elder);
                cashboxOnScreen(elder);
                synchronized (elder) {

                    elder.notify();
                    System.out.flush();
                }
            } else {
                Buyer buyer = QueueBuyers.extract();
                if (buyer != null) {
                    System.out.println(this + " begin to service " + buyer);
                    int t = Utils.getRandom(1, 5);
                    Utils.waitForSeconds(t);

                    System.out.println(this + " finished to service " + buyer);
                    cashboxOnScreen(buyer);


                    synchronized (buyer) {

                        buyer.notify();
                        System.out.flush();
                    }
                } else {
                    Utils.waitForSeconds(0.1f);
                }
            }

        }
        System.out.println(this + " closed");
    }


    void setActive() {
        synchronized (this) {
            if (!this.isActive) {
                this.notify();
                System.out.println(this + " reactivated due to excess of customers.");
                this.isActive = true;
            }

        }
    }

    synchronized void deactivate() {
        try {
            if (this.isActive) {
                System.out.println(this + " suspended due to lack of customers.");
                this.wait();
                isActive = false;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public String printCheck(int spaces, Buyer buyer) {
        int payment = 0;
        StringBuilder sb = new StringBuilder();
        //setDelimiters
        StringBuilder delimiter = Utils.setDelimiters(spaces);

        sb.append(delimiter).append("Список покупок ").append(buyer).append(":").append("\n");
        sb.append(delimiter).append("┌──────────────────────────────────────┐\n");


        for (Map.Entry<String, Integer> entry : buyer.getGoods().entrySet()) {
            payment += entry.getValue();
            sb.append(delimiter).append("|");
            sb.append(entry.getKey())
                    .append(".........")
                    .append(entry.getValue())
                    .append(" р.│\n");

        }
        setSumOnCashBox(payment);

        sb.append(delimiter).append("└──────────────────────────────────────┘\n");
        sb.append(delimiter)
                .append("Сумма счета ")
                .append(buyer)
                .append(": ")
                .append(payment)
                .append("\n");
        return sb.toString();
    }

    @SuppressWarnings("DuplicateBranchesInSwitch")
    private synchronized void cashboxOnScreen(Buyer buyer) {
        //cashBounty += buyer.getSum();
        StringBuilder sb = new StringBuilder();
        StringBuilder footer = new StringBuilder();
        String strCash;

        //printTop
        Utils.printTop(sb); //╔═╗
        //printHeader
        Utils.printHeader(sb);
        //printBottom
        Utils.printBottom(sb);//╚═╝
        Utils.printTop(sb);//╔═╗

        switch (cNum) {
            case 1:
                sb.append(printCheck(0, buyer));
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters(cNum), "Сумма по кассе: ", getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 2:
                sb.append(printCheck(40 + cNum, buyer));
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters(40 + cNum), "Сумма по кассе: ", getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 3:
                sb.append(printCheck((cNum - 1) * 40 + cNum, buyer));
                strCash = String.format(
                        "%s%s%d",
                        Utils.setDelimiters((cNum - 1) * 40 + cNum),
                        "Сумма по кассе: ",
                        getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 4:
                sb.append(printCheck((cNum - 1) * 40 + cNum, buyer));
                strCash = String.format(
                        "%s%s%d",
                        Utils.setDelimiters((cNum - 1) * 40 + cNum),
                        "Сумма по кассе: ",
                        getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 5:
                sb.append(printCheck((cNum - 1) * 40 + cNum, buyer));
                strCash = String.format(
                        "%s%s%d",
                        Utils.setDelimiters((cNum - 1) * 40 + cNum),
                        "Сумма по кассе: ",
                        getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            default:
                break;
        }
        Utils.setBottomLine(footer.toString());
        Utils.printBottom(sb);//╚═╝
        Utils.printTop(sb);//╔═╗
        sb.append(Utils.getBottomLine());
        Utils.printBottom(sb);//╚═╝
        System.out.println(sb.toString());
        System.out.printf("Текущий размер очереди: %d\n\n", Manager.currentQueueSize());
    }


    @Override
    public String toString() {
        return name;
    }


}
