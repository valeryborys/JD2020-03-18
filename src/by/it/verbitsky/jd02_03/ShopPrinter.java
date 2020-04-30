package by.it.verbitsky.jd02_03;


class ShopPrinter {
    private ShopPrinter() {
    }


    private static final String DELAULT_COLUMN_TAB = "\t\t\t\t\t\t";
    private static final String HEADER_COLUMN_TAB = "\t\t\t\t";
    private static final String CHECK_HEADER = "Check detail info:";
    private static final String CHECK_FOOTER = "<Check sum>: ";

    private static final String TABLE_HEADER = "Cashier1"
            .concat(HEADER_COLUMN_TAB)
            .concat("Cashier2")
            .concat(HEADER_COLUMN_TAB)
            .concat("Cashier3")
            .concat(HEADER_COLUMN_TAB)
            .concat("Cashier4")
            .concat(HEADER_COLUMN_TAB)
            .concat("Cashier5")
            .concat(HEADER_COLUMN_TAB)
            .concat("Total shop cash");

    //сделал отдельный монитор вместо синхронизированных методов
    //т.к. в методе принтчек по мимо печати выполняется логика
    //для экономии времени на логику синхронизация происходит только "в нужном месте"
    private static final Object printMonitor = new Object();

    public static void printMessage(String message) {
        synchronized (printMonitor) {
            System.out.println(message);
        }
    }

    public static void printCheck(NCashier cashier, Buyer buyer, Shop shop) {
        int tabsCount = cashier.getCashierId() - 1;
        StringBuilder checkTab = new StringBuilder();
        double checkSum = 0;
        for (int i = 0; i < tabsCount; i++) {
            checkTab.append(DELAULT_COLUMN_TAB);
        }
        StringBuilder totalTab = new StringBuilder();
        for (int i = 0; i < shop.getCashierLimit() - cashier.getCashierId() - 1; i++) {
            totalTab.append(DELAULT_COLUMN_TAB);
        }
        synchronized (printMonitor) {
            System.out.println(TABLE_HEADER);
            System.out.println(checkTab + CHECK_HEADER);

            for (Good good : buyer.getBasket().getGoodList()) {
                checkSum += good.getPrice();
                System.out.printf("%s%s : %3.2f\n", checkTab, good.getName(), good.getPrice());
            }
            shop.getShopManager().setTotalCash(checkSum);

            System.out.printf("%s%s%3.2f%S  \t\t%5.2f\n",
                    checkTab,
                    CHECK_FOOTER,
                    checkSum,
                    totalTab,
                    shop.getShopManager().getTotalCash());
        }
    }
}
