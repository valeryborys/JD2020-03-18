package by.it.borys.jd02_06;

public class Runner {
    static class Th extends Thread {
        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (System.out){
            Logger logger = Logger.getInstance();
          try{
            logger.log(getName());
            throw new RuntimeException();}
          catch (RuntimeException e){
              logger.log("Runtime Exception for "+getName());
          }
            }
        }
    }
    public static void main(String[] args) {
            for (int i = 0; i <10 ; i++) {
            new Th("th"+i).start();

        }
    }
}
