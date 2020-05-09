package by.it.gutkovsky.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.gutkovsky.jd02_05.resources.language";
    private Locale locale;
    private ResourceBundle bundle;

    ResMan() {
        this.locale = Locale.US;
        setLocale(locale);
    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(
                BASE_NAME, locale
        );
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    String get(String key){
        return bundle.getString(key);
    }
}
