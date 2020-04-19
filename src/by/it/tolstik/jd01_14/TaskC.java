package by.it.tolstik.jd01_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        System.out.println(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
}
