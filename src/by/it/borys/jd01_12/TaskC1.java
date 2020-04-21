package by.it.borys.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        ArrayList<String> values = getWords();
        int length = values.size();
        Set<Integer> keys = getKeys(length);
        Map<Integer,String> c = new TreeMap<>();
        int i=0;
        for (Integer key : keys) {
            c.put(key, values.get(i));
            i++;
        }
        System.out.println(c);
        Map<String,Integer> temp = new HashMap<>();
        Set<Map.Entry<Integer, String>> entries = c.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            temp.put(entry.getValue(),entry.getKey());
        }
        c.clear();
        Set<Map.Entry<String, Integer>> entries1 = temp.entrySet();
        for (Map.Entry<String, Integer> ent : entries1) {
            c.put(ent.getValue(),ent.getKey());
        }
        System.out.println(c);
    }

    private static ArrayList<String> getWords(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listOfValues = new ArrayList<>();
        for (;; ) {
            String text = sc.nextLine();
            if (text.equals("end")) {
                break;
            }
            listOfValues.add(text);
        }
        return listOfValues;
    }
    private static HashSet<Integer> getKeys(int length){
        HashSet<Integer> keys = new HashSet<>(length);
       while (keys.size() != length ) {
            int a = (int)(Math.random()*1000);
            keys.add(a);
        }
       return keys;
    }
}
