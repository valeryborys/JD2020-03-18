package by.it.gutkovsky.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueCashier {

    private static final BlockingDeque<Cashier> staff = new LinkedBlockingDeque<>();

    static void addStaff(Cashier cashier) {
        staff.addLast(cashier);
    }

    static Cashier getStaff() {
        return staff.pollFirst();
    }

    static int waitingStaff() {
        return staff.size();
    }

    static BlockingDeque<Cashier> queueStaff(){
        return staff;
    }
}
