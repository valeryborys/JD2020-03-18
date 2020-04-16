package by.it.sinevich.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    static void readData() throws Exception {
        double num;
        int err=0;
        String str;
        List<Double> list=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                num=Double.parseDouble(sc.next());
                list.add(num);
            } catch (NumberFormatException e) {
                err++;
                if(err==5){
                    throw new Exception(e);
                }else {
                    Thread.sleep(100);
                    for (int i = list.size()-1; i >= 0; i--) {
                        System.out.print(list.get(i)+" ");
                    }
                }

            }
        }

        }


    public static void main(String[] args) throws Exception {
        readData();

    }
}
