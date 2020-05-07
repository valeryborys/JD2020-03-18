package by.it.borys.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static final String BASE_NAME = "by.it.borys.calc.res.language";
    private Locale locale;
    private ResourceBundle bundle;
    public static  ResMan res = ResMan.INSTANCE;

    ResMan() {
         locale = Locale.getDefault();
         setLocale(locale);
    }

   void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }
    String get(String key){
        return  bundle.getString(key);
    }
}
