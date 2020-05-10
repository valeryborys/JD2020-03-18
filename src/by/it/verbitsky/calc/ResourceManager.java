package by.it.verbitsky.calc;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {
    INSTANCE;
    public static final String BASE_NAME = "by.it.verbitsky.calc.res.calcMessages";
    private ResourceBundle rb;
    private Locale locale;

    //конструктор по умолчанию задает локаль англ
    ResourceManager() {
        locale = Locale.US;
        setLocaleForBundle(locale);

    }

    public void setLocaleForBundle(Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String getMessage(String key) {
        return rb.getString(key);
    }

}