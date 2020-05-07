package by.it.okatov.calc.globalization;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private static final String BASE_NAME = "by.it.okatov.calc.temp.globalization.resources.language";
    private ResourceBundle bundle;

    ResourceManager() {
        Locale locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String getString(String key) {
        return bundle.getString(key);
    }
}
