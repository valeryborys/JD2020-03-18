package by.it.gutkovsky.jd02_02;


class Manager {

    static final int K_SPEED = 100;
    static final Object MONITOR = new Object();

    // block for checking / controlling customers quantity
    private static final int PLAN = 100;
    private volatile static int comeIn = 0;
    private volatile static int comeOut = 0;

    static boolean shopOpen() {
        return comeIn < PLAN;
    }

    static boolean planComplete () {
        return comeIn == PLAN;
    }

    static void customerComeIn() { // increasing quantity of buyers, when new buyer comes
        synchronized (MONITOR) {
            comeIn++;
        }
    }

    static void customerComeOut() { // decreasing quantity of buyers, when buyer left
        synchronized (MONITOR) {
            comeOut++;
        }
    }

    static boolean allCustomersCameOut(){
        return  comeOut == comeIn;
    }

    static int checkingQuantityInShop() { // temporary method for checking
        return comeIn - comeOut;
    }


}
