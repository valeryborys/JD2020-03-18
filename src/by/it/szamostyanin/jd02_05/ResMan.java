package by.it.szamostyanin.jd02_05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    public static final String BASE_NAME = "by.it.szamostyanin.jd02_05.res.language";
    private Locale locale;
    private ResourceBundle bundle;
    private DateTimeFormatter formatter;
    LocalDate date;

    ResMan() {
        locale = Locale.US;
        setLocale(locale);
        formatter = DateTimeFormatter.ofPattern(getString(User.DATE), locale);
        date = LocalDate.now();
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        formatter = DateTimeFormatter.ofPattern(getString(User.DATE), getLocaleFromBundle());
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public Locale getLocaleFromBundle() {
        return bundle.getLocale();
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public LocalDate getDate() {
        return date;
    }
}