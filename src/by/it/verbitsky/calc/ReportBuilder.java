package by.it.verbitsky.calc;

public interface ReportBuilder {
    void setOptionFullReport(boolean option);

    void setOptionShowTimestamp(boolean option);

    void setEventCollector(EventCollector collector);

    Report createReport();
}
