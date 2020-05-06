package by.it.tolstik.jd02_02.test;

class MyTest extends Thread {

    private static final Object MONITOR = new Object();

    static void sleep(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void run() {

        synchronized (this) {
            System.out.println("Корабль приплыл");
            sleep(1000);
            System.out.println("Корабль принят на разгрузку");
            sleep(500);
            System.out.println("Корабль разгрузился");
            sleep(500);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println("Корабль уплыл");
            sleep(500);
        }


    }

    public static void main(String[] args) {

        System.out.println("Порт открыт");

        MyTest thread = new MyTest();
        thread.start();
        Help.sleep(1);

        synchronized (thread) {
            thread.notify();
            System.out.println("Все ок, можно уплывать");

        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        System.out.println("Порт закрылся");
    }
}
