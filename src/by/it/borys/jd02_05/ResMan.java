package by.it.borys.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static final String BASE_NAME = "by.it.borys.jd02_05.res.language";
    private Locale locale;
    private ResourceBundle bundle;

    ResMan() {
         locale = Locale.US;
         setLocale(locale);
    }

   void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }
    String get(String key){
        return  bundle.getString(key);
    }
}
