package by.it.okatov.calc.Report;

import by.it.okatov.calc.CalcException;
import by.it.okatov.calc.globalization.IError;
import by.it.okatov.calc.logsystem.LogSystem;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.okatov.calc.ConsoleRunner.manager;
import static by.it.okatov.jd01_15.TaskB.getFileName;

public class ReportBuilder extends AbstractReport {
    private boolean isFullReport;
    private boolean isInput;
    private boolean isOutput;
    private boolean logListSet = false;
    private static final StringBuilder sb = new StringBuilder();
    private final List<String> logList = new ArrayList<>();


    private void setLogList() {
        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(
                                LogSystem.getFullPathToLog()
                        )
                )
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                this.logList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReportBuilder shortVariant() {
        if (!logListSet) {
            setLogList();
            logListSet = true;
        }

        this.isFullReport = false;
        return this;
    }

    @Override
    public ReportBuilder fullVariant() {
        if (!logListSet) {
            setLogList();
            logListSet = true;
        }

        this.isFullReport = true;
        return this;
    }

    @Override
    public ReportBuilder addHeader() {
        if (isFullReport) {
            sb.append("Full Report:\n");
        } else {
            sb.append("Short Report:\n");
        }
        return this;
    }

    @Override
    public ReportBuilder addStartTime() {
        if (!logListSet) {
            setLogList();
            logListSet = true;
        }
        if (isFullReport) {
            //DD.MM.YY HH.MM.SS
            Pattern p = Pattern.compile("((([0-9]{2})\\.*){3}) ((:?[0-9]{2}){3})");
            Matcher matcher = p.matcher(logList.get(0));
            if (matcher.find()) {
                sb.append(matcher.group()).append("\n");
            }
        } else {
            //HH.MM.SS
            Pattern p = Pattern.compile("((:?[0-9]{2}){3})");
            Matcher matcher = p.matcher(logList.get(0));
            if (matcher.find()) {
                sb.append(matcher.group()).append("\n");
            }
        }
        return this;
    }

    @Override
    public ReportBuilder addStrings() {
        if (!logListSet) {
            setLogList();
            logListSet = true;
        }
        addIOStrings();
        if (isInput && isOutput) {
            logList.forEach(line -> sb.append(line).append("\n"));
        } else if (isOutput) {
            logList.forEach(line -> {
                if (!line.contains("SYSTEM.INPUT")) {
                    if (line.contains(manager.getString(IError.msgErrorError))) {
                        sb.append("Exception ").append(CalcException.class).append("\n");
                    } else {
                        sb.append(line).append("\n");
                    }

                }
            });
        }
        return this;
    }

    void addIOStrings() {
        isInput = isFullReport;
        isOutput = true;
    }

    @Override
    public ReportBuilder addFinishTime() {
        if (!logListSet) {
            setLogList();
            logListSet = true;
        }
        if (isFullReport) {
            //DD.MM.YY HH.MM.SS
            Pattern p = Pattern.compile("((([0-9]{2})\\.*){3}) ((:?[0-9]{2}){3})");
            Matcher matcher = p.matcher(logList.get(logList.size() - 1));
            if (matcher.find()) {
                sb.append(matcher.group()).append("\n");
            }
        } else {
            //HH.MM.SS
            Pattern p = Pattern.compile("((:?[0-9]{2}){3})");
            Matcher matcher = p.matcher(logList.get(logList.size() - 1));
            if (matcher.find()) {
                sb.append(matcher.group()).append("\n");
            }
        }
        return this;
    }

    @Override
    public String createReport() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.getDefault());
        Date date = new Date();
        String extension = ".txt";
        String fileName = "reports" + File.separator + df.format(date) + " report";
        fileName = fileName.replace(" ", "_");
        fileName = fileName.replace(".", "_");
        fileName = fileName.replace(":", "_");
        fileName += extension;
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(
                                getFileName(ReportBuilder.class, fileName), false
                        )
                )
        ) {
            writer.print(sb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
