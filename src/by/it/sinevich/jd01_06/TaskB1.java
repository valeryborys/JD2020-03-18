package by.it.sinevich.jd01_06;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static ArrayList<String> prov(String[] array){
        ArrayList<String> list = new ArrayList<String>();
        Character[] g = new Character[]{'у','У','е','Е','ы','Ы','а','А','о','О','э','Э','я','Я','и','И','ю','Ю','ё','Ё'};
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j<g.length; j++){
                int d = array[i].length();
                if(d>1&&array[i].charAt(0)!=g[j]&& array[i].charAt(d-1)==g[j]){
                    list.add(array[i]);
                }

            }
        }

        for (int i = 0; i < list.size(); i++) {
            for(int j=0;j<g.length;j++){
                if(list.get(i).charAt(0)==g[j])
                    list.remove(i);
                }
            }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
        return list;
    }
    public static void main(String[] args) {
        String str = Poem.text;
        String[] array = str.split("[^а-яА-ЯёЁ]");
        //for (String s : array) {
        //   System.out.println(s);
        //}
        prov(array);
        }
    }
