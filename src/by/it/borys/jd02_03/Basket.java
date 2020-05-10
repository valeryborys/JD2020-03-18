package by.it.borys.jd02_03;

import java.util.HashMap;
import java.util.concurrent.Semaphore;


public class Basket {
   private HashMap<String,Integer> basket = new HashMap<>();
   public static Semaphore basketSemaphore = new Semaphore(50);
   Basket(){
       try {
           basketSemaphore.acquire();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
    synchronized void putToBasket(String name, Integer value){
       basket.put(name,value);
    }
    HashMap<String,Integer> takeFromBasket(){
     return basket;
    }
}
