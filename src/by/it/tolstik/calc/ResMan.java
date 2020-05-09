package by.it.tolstik.calc;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;
    public static final String BASE_NAME = "by.it.tolstik.calc.res.language";
    Locale locale;
    private ResourceBundle bundle;

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    String get(String key) {
        return bundle.getString(key);
    }
}