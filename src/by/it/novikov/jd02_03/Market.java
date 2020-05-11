package by.it.novikov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market {
    public static void main (String[] args){
        System.out.println("The market opened");
        ExecutorService pool= Executors.newFixedThreadPool(5);
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier= new Cashier(i);
            pool.execute(cashier);

        }
        pool.shutdown();

        while(Dispatcher.marketIsOpened()){

            int currentCount=Helper.random(2);
            for (int i = 0; i < currentCount&&Dispatcher.marketIsOpened(); i++) {
                int number= Dispatcher.getNumberBuyer();
                Buyer buyer= new Buyer(++number);
                buyer.start();}

            Helper.sleep(1000);

        }
            try{
                while (!pool.awaitTermination(120, TimeUnit.SECONDS)){
                    System.out.println("Long waiting");
                }
        }catch(InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("The market closed");


    }



}