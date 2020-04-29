package by.it.sinevich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    //Спросить, почему запись через метод dos.writeChars(result) записал файл с пробелами.

    private static String dir(Class<? > cl){
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int b = 0;
        FileReader fr = null;
        DataOutputStream dos = null;
        int words = 0;
        int marks = 0;
        try {
            fr = new FileReader(dir(TaskB.class)+"text.txt");
            while((b=fr.read())!=-1){
                sb.append((char) b);
            }
            Pattern pattern1 = Pattern.compile("\\p{Punct}+");
            Pattern pattern2 = Pattern.compile("[А-Яа-яёЁ]+");
            Matcher matcher1 = pattern1.matcher(sb);
            Matcher matcher2 = pattern2.matcher(sb);
            while (matcher1.find()){
                marks++;
            }
            while (matcher2.find()){
                words++;
            }
            String result = "words="+words+", punctuation marks="+marks;
            System.out.println("words="+words+", punctuation marks="+marks);

            dos=new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskB.class)+"resultTaskB.txt"))
            );
            //dos.writeChars(result);
            byte[] res = result.getBytes();
            dos.write(res);


        } catch (IOException e) {
            e.printStackTrace();

        }
        finally {
            if(dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
