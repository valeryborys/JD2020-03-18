package by.it.borys.calc;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportShortBuilder extends ReportBuilder{

    @Override
    public void reportHeading() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String g = ResMan.res.get("startTime")+sdf.format(d);
        super.report.addLast(g);
    }

    @Override
    public void reportBody(String str) {
        super.report.addLast(str);

    }

    @Override
    public void reportClosing() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String g = ResMan.res.get("closeTime")+sdf.format(d);
        super.report.addLast(g);
        super.printReport();
    }



}
