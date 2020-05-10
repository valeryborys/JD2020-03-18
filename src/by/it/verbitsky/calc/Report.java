package by.it.verbitsky.calc;

class Report {

    private boolean showTimeStamp = false;
    private boolean fullReport = false;
    private EventCollector eventCollector;

    public Report(boolean showTimeStamp, boolean fullReport, EventCollector eventCollector) {
        this.showTimeStamp = showTimeStamp;
        this.fullReport = fullReport;
        this.eventCollector = eventCollector;
    }

    public void ShowTimeStamp(boolean showTimeStamp) {
        this.showTimeStamp = showTimeStamp;
    }

    public void FullReport(boolean fullReport) {
        this.fullReport = fullReport;
    }

    public void setEventCollector(EventCollector eventCollector) {
        this.eventCollector = eventCollector;
    }

    public void print() {
        if (eventCollector != null) {
            printHeader();
            for (CalcEvent event : eventCollector.getEvents()) {
                System.out.println(event.getStringEvent(fullReport, showTimeStamp));
            }
            printFooter();
        } else {
            System.out.println("Event collector not found. Use ReportBuilder instance methods to build report");
        }
    }

    private void printFooter() {
        int errCount = eventCollector.getErrorEventsCount();
        int opCount = eventCollector.getEventsCount();
        if (fullReport) {
            System.out.printf(Patterns.FULL_REPORT_FOOTER, errCount, opCount, (errCount + opCount));
        } else {
            System.out.printf(Patterns.SIMPLE_REPORT_FOOTER, (errCount + opCount));
        }
    }

    private void printHeader() {
        if (fullReport) {
            System.out.printf(Patterns.FULL_REPORT_HEADER,
                    eventCollector.getStartTimeStamp(),
                    eventCollector.getEndTimeStamp()
            );
        } else {
            System.out.printf(Patterns.SIMPLE_REPORT_HEADER,
                    eventCollector.getStartTimeStamp(),
                    eventCollector.getEndTimeStamp()
            );
        }
    }
}
