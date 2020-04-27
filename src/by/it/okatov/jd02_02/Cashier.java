package by.it.okatov.jd02_02;

class Cashier implements Runnable {

    private final String name;
    private final int cNum;
    private int cashBounty = 0;
    private int counter = 0;
    final StringBuilder bottomLine = new StringBuilder();

    int getNumberOfServed() {
        return counter;
    }

    void setNumberOfServed(int counter) {
        this.counter = counter;
    }

    Cashier(int number) {
        this.cNum = number + 1;
        name = "\tCashier #" + (number + 1);
    }

    @Override
    public void run() {
        System.out.println(this + " Opened");
        //serveBuyer
        serveBuyer();
        System.out.println(this + " closed");
        System.out.println("Количество обслуженных покупателей у" + this + " равняется: " + getNumberOfServed());
    }

    private void serveBuyer() {
        while (!Manager.planComplete()) {
            Buyer buyer = BuyersQueue.extract();
            if (buyer != null) {
                System.out.println(this + " begins to service " + buyer);
                int t = Utils.getRandom(2, 5);
                Utils.waitForSeconds(t);
                //System.out.println(buyer.printCheck());

                //cashboxOnScreen
                cashboxOnScreen(buyer);


                counter++;


                System.out.println(this + " finishes servicing " + buyer);
                synchronized (buyer) {

                    buyer.notify();
                    System.out.flush();
                }

            } else {
                Utils.waitForSeconds(1);
            }
        }
    }

    @SuppressWarnings({"UnclearExpression", "DuplicateBranchesInSwitch"})
    private void cashboxOnScreen(Buyer buyer) {
        //cashBounty += buyer.getSum();
        StringBuilder sb = new StringBuilder();

        String strCash = "";
        //printTop
        printTop(sb); //╔═╗
        //printHeader
        printHeader(sb);
        //printBottom
        printBottom(sb);//╚═╝
        printTop(sb);//╔═╗

        switch (cNum) {
            case 1:
                sb.append(buyer.printCheck(cNum));

                cashBounty += buyer.getSum();
                strCash = String.format("%s%s%d", Utils.setDelimiters(cNum), "Сумма по кассе: ", cashBounty);
                bottomLine.append(String.format("%40s\n", strCash));
                break;
            case 2:
                sb.append(buyer.printCheck(40 + cNum));
                cashBounty += buyer.getSum();
                strCash = String.format("%s%s%d", Utils.setDelimiters(40 + cNum), "Сумма по кассе: ", cashBounty);
                bottomLine.append(String.format("%40s\n", strCash));
                break;
            case 3:
                sb.append(buyer.printCheck((cNum - 1) * 40 + cNum));
                cashBounty += buyer.getSum();
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters((cNum - 1) * 40 + cNum), "Сумма по кассе: ", cashBounty
                );
                bottomLine.append(String.format("%40s\n", strCash));
                break;
            case 4:
                sb.append(buyer.printCheck((cNum - 1) * 40 + cNum));
                cashBounty += buyer.getSum();
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters((cNum - 1) * 40 + cNum), "Сумма по кассе: ", cashBounty
                );
                bottomLine.append(String.format("%40s\n", strCash));
                break;
            case 5:
                sb.append(buyer.printCheck((cNum - 1) * 40 + cNum));
                cashBounty += buyer.getSum();
                strCash = String.format(
                        "%s%s%d", Utils.setDelimiters((cNum - 1) * 40 + cNum), "Сумма по кассе: ", cashBounty
                );
                bottomLine.append(String.format("%40s\n", strCash));
                break;
            default:
                break;
        }

        printBottom(sb);//╚═╝
        printTop(sb);//╔═╗
        sb.append(bottomLine.toString());
        printBottom(sb);//╚═╝
        System.out.println(sb.toString());
    }

    private void printHeader(StringBuilder sb) {

        sb.append("║---------------").append("Cashier #1").append("---------------")
                .append("║---------------").append("Cashier #2").append("---------------")
                .append("║---------------").append("Cashier #3").append("---------------")
                .append("║---------------").append("Cashier #4").append("---------------")
                .append("║---------------").append("Cashier #5").append("---------------║\n");

    }

    private void printBottom(StringBuilder sb) {
        sb.append("╚════════════════════════════════════════╩")
                .append("════════════════════════════════════════╩")
                .append("════════════════════════════════════════╩")
                .append("════════════════════════════════════════╩")
                .append("════════════════════════════════════════╝\n");
    }

    private void printTop(StringBuilder sb) {
        sb.append("╔════════════════════════════════════════╦")
                .append("════════════════════════════════════════╦")
                .append("════════════════════════════════════════╦")
                .append("════════════════════════════════════════╦")
                .append("════════════════════════════════════════╗\n");
    }

    @Override
    public String toString() {
        return name;
    }
}


















