package by.it.szamostyanin.jd01_04;

public class TaskA {
    static void printMulTable(){
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j <= 10 ; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMulTable();
    }
}
