package by.it.okatov.jd01_12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TaskC1 {
    public static void main(String[] args) {
        Map<Long, String> hMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String input = "";
        String tmp;
        int seed = 800;
        while (true) {
            tmp = sc.nextLine();
            if (tmp.equals("end")) {
                break;
            } else {
                input += tmp + " ";
            }

        }

        String[] sArr = input.split(" ");
        System.out.println("Size of product's list: " + sArr.length);

        int i = 0;
        try {
            for (String s : sArr) {
                System.out.print(++i + " ");
                hMap.put(uniqueIDGenerator(seed), s);
            }
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }


        System.out.println("\n\nHashmap sorted: " + hMap.size());
        Stream<Map.Entry<Long, String>> stream = hMap.entrySet().stream();
        Stream<Map.Entry<Long, String>> sorted = stream.sorted(Map.Entry.comparingByKey());
        hMap = sorted.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(hMap);
        /*sorted.forEach(System.out::println);*/


        Iterator<Map.Entry<Long, String>> iterator = hMap.entrySet().iterator();
        System.out.println("After doubles removing: " + hMap.size());
        Set<String> existing = new HashSet<>();
        sorted = hMap.entrySet().stream().filter(entry -> existing.add(entry.getValue()));
        hMap = sorted.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(hMap);
        /*while (iterator.hasNext())
        {
            Map.Entry<Long,String> pair = iterator.next();
            Long key = pair.getKey();
            String val = pair.getValue();
            System.out.printf("Key: %d -> Value: %s%n", key,val);
        }*/
    }


    @SuppressWarnings("StringConcatenationInLoop")
    private static String uniqueIDGenerator() throws NoSuchAlgorithmException {
        String s;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        long time = System.currentTimeMillis() + (long) (System.nanoTime() / 1e5) - (long) (Math.random() / 1e3 * 10 + 1);
        byte[] uid = Long.toString(time).getBytes();
        byte[] digest = md5.digest(uid);
        s = "";
        for (byte b : digest) {
            s += b;
        }
        s = s.replaceAll("-", "");
        //System.out.println("UID: " + s);
        return s;


    }

    @SuppressWarnings("StringConcatenationInLoop")
    private static long uniqueIDGenerator(int seed) throws NoSuchAlgorithmException {
        String s;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        long time = System.currentTimeMillis() + System.nanoTime() - (long) (Math.random() / 1e5 * seed + 1);
        byte[] uid = Long.toString(time).getBytes();
        byte[] digest = md5.digest(uid);
        s = "";
        for (byte b : digest) {
            s += b;
        }
        s = s.replaceAll("-", "");
        s = s.substring(0, 16);
        //System.out.println("UID: " + s);
        return Long.parseLong(s);


    }
}
