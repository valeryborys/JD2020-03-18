package by.it.borys.calc;

public class ReportDirector {
    ReportBuilder builder;

    void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    void reportHeading() {
        builder.reportHeading();
    }

    void reportBody(String str) {
        builder.reportBody(str);
    }

    void reportClosing() {
        builder.reportClosing();
    }
}

