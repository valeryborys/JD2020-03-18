package by.it.okatov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourcesManager {
    INSTANCE;

    private static final String BASE_NAME = "by.it.okatov.jd02_05.Resources.language";
    private ResourceBundle bundle;

    ResourcesManager() {
        Locale locale = Locale.getDefault();
        setLocale(locale);
    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    String getString(String key) {
        return bundle.getString(key);
    }
}
