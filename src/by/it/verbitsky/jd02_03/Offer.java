package by.it.verbitsky.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Offer {
    private Map<String, Double> offers = new HashMap<>();

    public Offer() {
        for (int i = 1; i < 11; i++) {
            offers.put(("Good" + i), Helper.getRandomPrice());
        }
    }

    public Good getRandomGood() {
        int goodNumber = Helper.getRandom(1, 10);
        for (Map.Entry<String, Double> entry : offers.entrySet()) {
            if (entry.getKey().contains(String.valueOf(goodNumber))) {
                return new Good(entry.getKey(), entry.getValue());
            }
        }
        return null;
    }


}
