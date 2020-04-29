package by.it.sinevich.jd01_15;

import java.io.*;

public class TaskB {
    //комментарий первый
    //комментарий второй
    /*комментарий первый
    многострочный
     */
    /*комментарий второй
    многострочный*/
    //*javaDOC/*


    private static String dir(Class<? > cl){
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader bf = null;
        try{
            bf=new BufferedReader(new FileReader(dir(TaskB.class)+"TaskB.java"));
            while((line=bf.readLine())!=null){
                sb.append(line).append("\n");
            }
            while(!(sb.indexOf("//")==-1)){
                sb.replace(sb.indexOf("//"), sb.indexOf("\n",sb.indexOf("//")),"");
            }
            while(!(sb.indexOf("/*")==-1)){
                sb.replace(sb.indexOf("/*"), sb.indexOf("*/")+2,"");
            }
            while(!(sb.indexOf("//*") ==-1)){
                sb.replace(sb.indexOf("//*"),sb.indexOf("\n", sb.indexOf("/*")),"");
            }
            System.out.println(sb);
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
        try {
            PrintWriter pw = new PrintWriter(dir(TaskB.class)+"TaskB.txt");
            pw.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    }


