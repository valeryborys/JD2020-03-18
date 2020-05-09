package by.it.borys.jd01_15;
/**
 * Javadoc
 * Javadoc
 */
import java.io.*;
//hgvhgvhg
//sdfhjbsdf
public class TaskB {
    public static void main(String[] args) {
        //hgvhgvhg
        StringBuilder s = readProgramText();
        printToTxt(s.toString());
    }
    /*
    iujhb
    khjbjhb
    khbjb
    ljnkj
     */
    private static StringBuilder readProgramText() {
        //создали стрингбилдер
        StringBuilder sb = new StringBuilder();
        try (DataInputStream dis = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(TaskA.dir(TaskB.class) + ".java")))) {
            InputStreamReader ist = new InputStreamReader(dis);
            int b = 0;
            int c = 0;
            /*
            тут еще один комментарий
             */
            boolean passOne = false;
            boolean passComJD = false;
            while ((b = ist.read()) > 0) {
                StringBuilder check = new StringBuilder();
                char c1 = (char) c;
                char b1 = (char) b;
                sb.append(b1);
                check.append(c1).append(b1);
                //  System.out.println(check);
                if ((c1 == '/' && b1 == '/')) {passOne = true;
                    sb.replace(sb.length()-1,sb.length(),"");
                }
                if (passOne && b1 == '\n') passOne = false;
                if (check.toString().equals("/*")) {
                    passComJD = true;
                    sb.replace(sb.length()-1,sb.length(),"");
                }
                if (passComJD && check.toString().equals("*/")) {
                    passComJD = false;
                    sb.replace(sb.length()-1,sb.length(),"");
                }
                if (passOne || passComJD) {
                    sb.replace(sb.length()-1,sb.length(),"");
                }
                c = b;
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
    private static void printToTxt(String str) {
        try (PrintWriter out = new PrintWriter(new FileWriter(TaskA.dir(TaskB.class)+".txt"))) {
            out.println(str.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
