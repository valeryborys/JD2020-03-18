package by.it.szamostyanin.Calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.szamostyanin.calc.res.language";
    private Locale locale;
    private ResourceBundle bundle;

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

    public Locale getLocaleFromBundle() {
        return bundle.getLocale();
    }
}
