package by.it.borys.jd01_14;

import java.io.*;

public class TaskA {
    public static String dir(Class<?> cl){
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clD = cl.getName().replace(".",File.separator).replace(cl.getSimpleName(),"");
        return path+clD;
    }
    public static void main(String[] args){
        System.out.println(dir(TaskA.class));
        DataOutputStream dos = null;
        try{
        dos = new DataOutputStream
                (new BufferedOutputStream
                        (new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")
                        )
                );
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int) (Math.random()*1000));

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (dos !=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try(DataInputStream input = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(dir(TaskA.class)+"dataTaskA.bin"))

                );
            PrintWriter txtOut = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))
           ) {double sum = 0;
        double count = 0;
        while (input.available()>0){
            int i = input.readInt();
            System.out.printf("%d ",i);
            txtOut.print(i+" ");
            sum+=i;
            count++;
        }
            System.out.println("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
