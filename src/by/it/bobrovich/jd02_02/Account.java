package by.it.bobrovich.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Account {
    Map<String, Integer> list = new HashMap<>();
    
    public Account(){
        
    }
    
    public void addToList(String listGood, Integer value){
        list.put(listGood, value);
    }

    public Map<String, Integer> getList() {
        return list;
    }
}
