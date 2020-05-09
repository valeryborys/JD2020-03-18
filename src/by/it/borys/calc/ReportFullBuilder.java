package by.it.borys.calc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportFullBuilder extends ReportBuilder{
    final String dateFormat = "HH:mm:ss - dd.MM.yyyy";
    @Override
    void reportHeading() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String g = ResMan.res.get("startTime")+sdf.format(d);
        super.report.addLast(g);
    }

    @Override
    void reportBody(String str) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String g = str+ResMan.res.get("logTime")+" "+sdf.format(d);
        super.report.addLast(g);
    }

    @Override
    void reportClosing() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String g = ResMan.res.get("closeTime")+sdf.format(d);
        super.report.addLast(g);
        super.printReport();
    }
}
