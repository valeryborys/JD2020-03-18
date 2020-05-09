package by.it.gutkovsky.calc;

import java.io.*;
import java.util.GregorianCalendar;


class FullReport extends ReportBuilder {

    @Override
    public void buildHeadline() {
        report.setHeadline("FULL REPORT | DATE OF CREATION: ");
    }

    @Override
    public void buildStartTime() {
        GregorianCalendar startTime = new GregorianCalendar();
        report.setStartTime(startTime.getTime());
    }

    @Override
    public void buildStopTime() {
        GregorianCalendar stopTime = new GregorianCalendar();
        report.setStopTime(stopTime.getTime());
    }

    @Override
    public void buildBodyReport() {
        String logFile = Printer.getFile("log.txt");
        File log = new File(logFile);
        StringBuilder stringBuilder = new StringBuilder();
        if (log.exists()) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log)))) {
                while (reader.ready()) {
                    stringBuilder.append(reader.readLine()).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            stringBuilder.append("There are no any event in logger");
        }
        report.setBodyReport(stringBuilder.toString());
    }
}
