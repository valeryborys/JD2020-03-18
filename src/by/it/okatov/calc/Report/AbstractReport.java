package by.it.okatov.calc.Report;

public abstract class AbstractReport {
    @SuppressWarnings("unused")
    public abstract ReportBuilder shortVariant(); //Method never used

    public abstract ReportBuilder fullVariant();

    public abstract ReportBuilder addHeader();

    public abstract ReportBuilder addStartTime();

    public abstract ReportBuilder addStrings();

    public abstract ReportBuilder addFinishTime();

    @SuppressWarnings("UnusedReturnValue")
    public abstract String createReport();//Return value never used
}
