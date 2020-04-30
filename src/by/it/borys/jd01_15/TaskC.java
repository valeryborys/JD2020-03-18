package by.it.borys.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
   static File f = new File(TaskA.dir(TaskC.class).replace("TaskC",""));
    public static void main(String[] args) {
        String path = f.getPath();
        String line="";
        System.out.print(path + ">");
        Scanner sc= new Scanner(System.in);
        String bufferdir = f.getPath();
        String res = "";
        while (!(line.equals("end"))) {
            line = sc.nextLine();

            if (line.equals("cd")) {
                System.out.print(bufferdir+">");
                continue;
            }
            else if (line.equals("cd ..")){
                bufferdir = returnDir(bufferdir);
                System.out.print(bufferdir+">");
            }

            else if (line.length()>2 && line.substring(0,3).equals("cd\\")){
               res= changeDirC(line.substring(3,line.length()));
           if (!res.equals("0")) bufferdir=res;
           else System.out.println("Системе не удается найти указанный путь.");
            System.out.print(bufferdir+">");
            }

            else if (line.length()>2 && line.substring(0,3).equals("cd ")){
                bufferdir = changeDir(bufferdir,line.substring(3,line.length()));
                System.out.print(bufferdir+">");
            }

          else   if (line.length()>2 && line.substring(0,3).equals("dir")){
                dir(bufferdir);
            }
          else if (!line.equals("end")){System.out.println("\""+line+"\" не является внутренней или внешней\n командой," +
                    "исполняемой программой или пакетным файлом.");
                System.out.print(bufferdir+">");
            }
        }
    }
    static String returnDir(String bufferdir){
        StringBuilder sb = new StringBuilder(bufferdir);
        if (sb.length()>3){
            sb.replace(sb.lastIndexOf(File.separator),sb.length(),"");
        return sb.toString();
        }else return bufferdir;
    }

    static String changeDirC(String str){
        String disk = f.getPath().substring(0,3);
        if (str.length()==0) return disk;
        else{
        File diskC = new File(disk);
        File[] dirs = diskC.listFiles();
        for (File dir : dirs) {
            if (dir.getName().equals(str)) return disk+str;
        }
        }
        return "0";
    }
    static String changeDir(String bufferdir, String str){
        if (str.length()==0) return bufferdir;
        else{
            File catalogue = new File(bufferdir);
          //  System.out.println(catalogue.getTotalSpace());
            File[] dirs = catalogue.listFiles();
            for (File dir : dirs) {
                if (dir.getName().equals(str) && bufferdir.length()==3) return bufferdir+str;
                if (dir.getName().equals(str)) return bufferdir+File.separator+str;
            }
            }
        return bufferdir;
    }

    static void dir(String bufferdir){
        System.out.println(" Содержимое папки "+bufferdir);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy  HH:mm");
        File catalogue = new File(bufferdir);
        File[] dirs = catalogue.listFiles();
        int countFiles=0;
        long sizeOfFiles =0;
        int countDirs =0;
        for (File dir : dirs) {
            String time="";
            String direct="";
            String size="";
            String name="";
            if (dir.isFile()){
                time = sdf.format(dir.lastModified());
                direct ="";
                size = String.valueOf(dir.length());
                name = dir.getName();
                countFiles++;
                sizeOfFiles+=dir.length();
            }
            if (dir.isDirectory()){
                time = sdf.format(dir.lastModified());
                direct ="<DIR>";
                size = "";
                name = dir.getName();
                countDirs++;
            }if (!dir.isHidden()) System.out.printf("%17s  %5s %9s %s\n",time,direct,size,name);
        }
        System.out.print("              "+countFiles+" файлов "+sizeOfFiles+" байт\n");
        System.out.print("              "+countDirs+" папок "+catalogue.getUsableSpace()+" байт свободно\n");
        System.out.print(bufferdir+">");
    }
}
