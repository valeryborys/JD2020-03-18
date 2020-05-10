package by.it.lemesh.jd02_06;

public class Runner {

    static class Th extends Thread {
        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger logger = Logger.getInstance();
            logger.log(getName());
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Th("Th " + i).start();
        }
    }

}
