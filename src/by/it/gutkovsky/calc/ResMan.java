package by.it.gutkovsky.calc;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.gutkovsky.calc.resources.language";
    private Locale locale;
    private ResourceBundle bundle;

    ResMan() {
        this.locale = Locale.getDefault();
//        this.locale = Locale.US; раскоментировать дляпрохождения теста  Test_jd01_13_for_calc
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
