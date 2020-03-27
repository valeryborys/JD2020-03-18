package by.it.verbitsky.jd01_03;

import java.util.Arrays;

import static by.it.verbitsky.jd01_03.MyTestsort.sort;

public class MyTestRun {
    public static void main(String[] args) {
        int[] arr ={2,1,0,6,1,9,8,7};//тестовый массив
        System.out.println(Arrays.toString(arr));//вывод на экран исходного массива
        int[] sortArr = sort(arr);//сортировка
        System.out.println(Arrays.toString(sortArr));//вывод на экран отсортированного массива

    }

}
