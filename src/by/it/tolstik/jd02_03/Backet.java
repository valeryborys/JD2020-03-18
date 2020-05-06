package by.it.tolstik.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Backet {

    private final String name;

    Backet(int number) {
        name = "backet # " + number;
    }

    static void initializationBacket() {
        for (int i = 1; i < 51; i++) {
            Backet.add(new Backet(i));
        }
    }

    static final BlockingDeque<Backet> dequeB = new LinkedBlockingDeque<>(50);

    static void add(Backet backet) {
        try {
            dequeB.putLast(backet);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    static Backet extract() {
        return dequeB.pollFirst();
    }

    static int getValueBacket() {
        return dequeB.size();
    }

    @Override
    public String toString() {
        return name;
    }

}
