package by.it.tolstik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;
    public static final String BASE_NAME = "by.it.tolstik.jd02_05.res.language";
    Locale locale;
    private ResourceBundle bundle;

//    ResMan() {
//        locale = Locale.US;
//        setLocale(locale);
//    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    String get(String key) {
        return bundle.getString(key);
    }
}
