package by.it.okatov.calc.Report;

public abstract class AbstractReport {
    public abstract ReportBuilder shortVariant();

    public abstract ReportBuilder fullVariant();

    public abstract ReportBuilder addHeader();

    public abstract ReportBuilder addStartTime();

    public abstract ReportBuilder addStrings();

    public abstract ReportBuilder addFinishTime();

    public abstract String createReport();
}
