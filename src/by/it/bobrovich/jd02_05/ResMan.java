package by.it.bobrovich.jd02_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.bobrovich.jd02_05.res.language";
    Locale locale;
    ResourceBundle bundle;
    SimpleDateFormat dateFormat;

    ResMan() {
        locale = Locale.US;
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public void showDate(Date date, String key) {
        dateFormat = new SimpleDateFormat(bundle.getString(key));
        System.out.println(dateFormat.format(date));
    }
}
