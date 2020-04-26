package by.it.sinevich.jd01_15;

import java.io.*;

public class TaskA {
    private static String dir(Class<? > cl){
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
               matrix[i][j]=(int)(Math.random()*(30+1))-15;
            }
        }


        PrintWriter pw =null;
        try{
            pw=new PrintWriter(
                    new FileWriter(dir(TaskA.class)+"matrix.txt"
                    ));
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                   pw.printf("%3d ",matrix[i][j]);
                }
                pw.printf("\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(pw!=null){
                pw.close();
            }
        }

        BufferedReader bf = null;
        try{
            bf=new BufferedReader(
                    new FileReader(dir(TaskA.class)+"matrix.txt"));
            for (int i = 0; i < matrix.length; i++) {
                    System.out.println(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bf!=null){
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
