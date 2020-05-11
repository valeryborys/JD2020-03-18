package by.it.lemesh.jd02_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.lemesh.jd02_05.res.language";
    private ResourceBundle bundle;
    private Locale locale;
    SimpleDateFormat date;

    ResMan() {
        Locale locale = Locale.US;
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        this.locale = locale;
        date = new SimpleDateFormat(get(DateFormat.dateFormat));
    }

    public String getDate() {
        return date.format(new Date());
    }

    public Locale getLocale() {
        return locale;
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
