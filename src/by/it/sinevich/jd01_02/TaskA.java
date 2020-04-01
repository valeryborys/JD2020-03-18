package by.it.sinevich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[]args){
        int[] mas = new int[10];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<mas.length; i++){
            mas[i]=sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }
    public static void step1(int[] mas){
        int min=mas[0];
        int max=mas[0];
        /*for(int i = 0; i < mas.length; i++) {
            if(mas[i]<min){
                min=mas[i];
            }
            }*/
        for (int element : mas) {
            if(element<min){
                min=element;
            }
        }
        /*for (int i = 0; i < mas.length; i++) {
            if(mas[i]>max){
                max=mas[i];
            }
        }*/
        for (int element : mas) {
            if(element>max){
                max=element;
            }
        }
        System.out.println(min+" "+max);
    }
    public static void step2(int[] mas){
        double arg = 0;
        /*for (int i = 0; i < mas.length; i++) {
            arg+=mas[i];
        }*/
        for (int element : mas) {
            arg+=element;
        }
        arg/=mas.length;
        /*for (int i = 0; i < mas.length; i++) {
            if(mas[i]<arg){
                System.out.println(mas[i]);
            }
        }*/
        for (int element : mas) {
            if(element<arg){
                System.out.println(element);
            }
        }
    }
    public static void step3(int[] mas){
        int min=mas[0];
        for (int i = mas.length-1; i >=0; i--) {
            if(mas[i]<=min){
                min=mas[i];
                System.out.print(i+" ");
            }
        }
    }
}
