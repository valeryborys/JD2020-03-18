package by.it.gutkovsky.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

class Report {
    private String headline;
    private Date startTime;
    private Date stopTime;
    private String bodyReport;

    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
    GregorianCalendar creationDate = new GregorianCalendar();

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public void setBodyReport(String bodyReport) {
        this.bodyReport = bodyReport;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------------------\n" +
                headline + df.format(creationDate.getTime()) + "\n" +
                "----------------------------------------------------------------------\n" +
                "Start of report generation: " + startTime + "\n" +
                "----------------------------------------------------------------------\n" +
                bodyReport + "\n" +
                "----------------------------------------------------------------------\n" +
                "End of report generation: " + stopTime + "\n" +
                "----------------------------------------------------------------------\n";
    }
}
