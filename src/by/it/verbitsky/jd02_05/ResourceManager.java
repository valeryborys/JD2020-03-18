package by.it.verbitsky.jd02_05;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {
    INSTANCE;
    public static final String BASE_NAME = "by.it.verbitsky.jd02_05.res.language";
    private ResourceBundle rb;
    private Locale locale;
    private DateTimeFormatter dateFormat;

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    //конструктор по умолчанию задает локаль англ
    ResourceManager() {
        locale = Locale.US;
        setLocaleForBundle(locale);
        dateFormat = DateTimeFormatter.ofPattern(rb.getString(MessageKeys.SYSTEM_DATE_FORMAT), this.locale);
    }

    public void setLocaleForBundle(Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(BASE_NAME, locale);
        dateFormat = DateTimeFormatter.ofPattern(rb.getString(MessageKeys.SYSTEM_DATE_FORMAT), this.locale);
    }

    public String getMessage(String key) {
        return rb.getString(key);
    }

}