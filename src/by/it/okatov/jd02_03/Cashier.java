package by.it.okatov.jd02_03;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Cashier implements Runnable {

    String name;

    private boolean isActive = false;
    public void setActive(boolean active) {
        isActive = active;
    }

    private final AtomicInteger number = new AtomicInteger(0);

    int getNumber() {
        return number.get();
    }

    void setNumber(int number) {
        this.number.set(number);
    }

    private int sumOnCashBox = 0;

    public int getSumOnCashBox() {
        return sumOnCashBox;
    }

    public void setSumOnCashBox(int nextSum) {
        this.sumOnCashBox += nextSum;
    }


    Cashier(int number) {

        setNumber(number);
        name = "\tCashier #" + getNumber() + ":";
        //deactivate();
    }

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
            Buyer buyer = BuyersQueue.extract();
            if (buyer != null && isActive) {
                System.out.println(this + " begins servicing " + buyer);
                int t = Utils.getRandom(2, 5);
                Utils.waitForSeconds(t);
                System.out.println(this + " has finished servicing " + buyer);
                cashboxOnScreen(buyer);


                synchronized (buyer) {
                    buyer.notify();
                    System.out.flush();
                }
            } else {
                Utils.waitForSeconds(0.1f);
            }
        }
        System.out.println(this + " closed");
    }

    void deactivate() {
        if (this.isActive) {
            System.out.println(this + " завершил работу из-за недостатка посетителей!");
            //this.wait();
            setActive(false);
        }

    }

    synchronized void setActive() {
        if (!this.isActive) {

            System.out.println("//------------------------Количество покупателей: " + Utils.GLOBAL_COUNTER.get());
            System.out.println(this + " начал работу из-за наплыва посетителей!");
            this.setActive(true);
            this.notify();
        }
    }

    @SuppressWarnings("DuplicateBranchesInSwitch")
    private synchronized void cashboxOnScreen(Buyer buyer) {
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

        switch (getNumber()) {
            case 1:
                sb.append(printCheck(0, buyer));
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters(getNumber()), "Сумма по кассе: ", getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 2:
                sb.append(printCheck(40 + getNumber(), buyer));
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters(40 + getNumber()), "Сумма по кассе: ", getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 3:
                sb.append(printCheck((getNumber() - 1) * 40 + getNumber(), buyer));
                strCash = String.format(
                        "%s%s%d",
                        Utils.setDelimiters((getNumber() - 1) * 40 + getNumber()),
                        "Сумма по кассе: ",
                        getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 4:
                sb.append(printCheck((getNumber() - 1) * 40 + getNumber(), buyer));
                strCash = String.format(
                        "%s%s%d",
                        Utils.setDelimiters((getNumber() - 1) * 40 + getNumber()),
                        "Сумма по кассе: ",
                        getSumOnCashBox()
                );
                footer.append(String.format("%40s\n", strCash));
                break;
            case 5:
                sb.append(printCheck((getNumber() - 1) * 40 + getNumber(), buyer));
                strCash = String.format(
                        "%s%s%d",
                        Utils.setDelimiters((getNumber() - 1) * 40 + getNumber()),
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
        System.out.printf("Текущий размер очереди: %d\n\n", Manager.inOut);
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

    @Override
    public String toString() {
        return name;
    }
}






























