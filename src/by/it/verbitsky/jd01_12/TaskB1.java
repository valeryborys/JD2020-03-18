package by.it.verbitsky.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> words = new TreeMap<>();

        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            word = word.replaceAll("([^a-zA-Z^']+)", "");
            //merge добавит новуб пару ключ:значение, если ключа не было в тримап: например один = 1
            //если ключ был, то вызовется метод суммирования двух интов
            //и единичка (с подсказкой value добавиться уже к существующему значению
            //По типу функции (Интежер, понятно к какому полю добавлять единичку)
            words.merge(word, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }
}
