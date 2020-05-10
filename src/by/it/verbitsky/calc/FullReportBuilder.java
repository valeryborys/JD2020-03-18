package by.it.verbitsky.calc;

class FullReportBuilder implements ReportBuilder {
    private boolean showTimeStamp = false;
    private boolean fullReport = false;
    private EventCollector eventCollector;


    @Override
    public void setOptionFullReport(boolean option) {
        fullReport = option;
    }

    @Override
    public void setOptionShowTimestamp(boolean option) {
        showTimeStamp = option;
    }

    @Override
    public void setEventCollector(EventCollector collector) {
        eventCollector = collector;
    }

    @Override
    public Report createReport() {
        return new Report(showTimeStamp, fullReport, eventCollector);
    }
}
