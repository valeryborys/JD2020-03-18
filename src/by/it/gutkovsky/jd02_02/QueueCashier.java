package by.it.gutkovsky.jd02_02;

import java.util.ArrayDeque;

class QueueCashier {

    private static final ArrayDeque<Cashier> staff = new ArrayDeque<>();

    static synchronized void addStaff(Cashier cashier) {
        staff.addLast(cashier);
    }

    static synchronized Cashier getStaff() {
        return staff.pollFirst();
    }

    static int waitingStaff() {
        return staff.size();
    }

    static ArrayDeque<Cashier> queueStaff(){
        return staff;
    }
}
