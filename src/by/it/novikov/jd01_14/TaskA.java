package by.it.novikov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    public static void main(String[] args) {
        String dataFileName = Helper.getPath("dataTaskA.bin");
        System.out.println(dataFileName);
        String resultFile = Helper.getPath("resultTaskA.txt");
        writeIntToBinFile(dataFileName);
        List<Integer> integers = new ArrayList<>();
        readToArrayList(integers, dataFileName);
        printArray(integers);
        printIntegersFromFile(dataFileName, resultFile);
    }

    private static void writeIntToBinFile(String filename) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readToArrayList(List<Integer> integers, String filename) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (dis.available() > 0) {
                integers.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void printArray(List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


    private static void printIntegersFromFile(String sourse, String directionFile) {
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                sourse)));
             PrintWriter printWriter = new PrintWriter(
                     new FileWriter(directionFile))) {
            double sum = 0;
            double count = 0;
            while (dataInputStream.available() > 0) {
                int i = dataInputStream.readInt();
                System.out.print(i + " ");
                printWriter.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
