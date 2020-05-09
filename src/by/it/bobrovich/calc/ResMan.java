package by.it.bobrovich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.bobrovich.calc.res.language";
    Locale locale;
    static ResourceBundle bundle;

    ResMan() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public static void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public static String getString(String key) {
        return bundle.getString(key);
    }

}
