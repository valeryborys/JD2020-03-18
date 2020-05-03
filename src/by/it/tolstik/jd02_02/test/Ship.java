package by.it.tolstik.jd02_02.test;


import java.util.ArrayDeque;
import java.util.Deque;

class Help {

    static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}

class Port extends Thread {

    @Override
    public void run() {

        System.out.println("Порт открылся!!!!!!!!");
        System.out.println("_____________________");
        synchronized (this) {
            try {
                Runner.add(this);
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("_____________________");
        System.out.println("Все, пипец, порт закрылся!!! (((");
    }
}

class Ship extends Thread {

    @Override
    public void run() {
        Help.sleep(100);
        System.out.println("Корабль приплыл");
        Help.sleep(1000);
        System.out.println("Корабль принят на разгрузку");
        Help.sleep(500);
        System.out.println("Корабль разгрузился");
        Help.sleep(500);
        System.out.println("Корабль уплыл");
        Help.sleep(500);
        Port extract = Runner.extract();
        synchronized (extract) {
            notify();
        }
    }
}

class Runner {

    static final Deque<Port> deque = new ArrayDeque<>();

    static synchronized void add(Port port) {
        deque.addLast(port);
    }

    static synchronized Port extract() {
        return deque.pollFirst();
    }

    public static void main(String[] args) {
        Port port = new Port();
        port.start();
        Ship ship = new Ship();
        ship.start();

    }
}
