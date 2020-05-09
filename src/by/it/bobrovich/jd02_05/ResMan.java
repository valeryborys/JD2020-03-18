package by.it.bobrovich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.bobrovich.jd02_05.res.language";
    Locale locale;
    ResourceBundle bundle;

    ResMan() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String getString(String key){
        return bundle.getString(key);
    }
}
