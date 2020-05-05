package by.it.borys.jd02_02;

import java.util.HashMap;


public class Basket {
   private HashMap<String,Integer> basket = new HashMap<>();

   Basket(){

   }
    synchronized void putToBasket(String name, Integer value){
       basket.put(name,value);
    }
    HashMap<String,Integer> takeFromBasket(){
     return basket;
    }
}
