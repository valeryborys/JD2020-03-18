package by.it.akhmelev.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.akhmelev.jd02_05.res.language";
    private Locale locale;
    private ResourceBundle bundle;

    ResMan() {
        locale = Locale.US;
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

}
