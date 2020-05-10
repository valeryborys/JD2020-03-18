package by.it.verbitsky.calc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class CalcEvent {

    private CalcEventType eventType;
    private StringBuilder eventBody = new StringBuilder();
    private LocalDateTime timeStamp;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Patterns.TIMESTAMP_PATTERN);


    public CalcEvent(CalcEventType eventType, String eventBody) {
        this.eventType = eventType;
        this.eventBody.append(" Event body: ").append(eventBody);
        this.timeStamp = LocalDateTime.now();
    }

    public CalcEventType getEventType() {
        return eventType;
    }

    public StringBuilder getEventBody() {
        return eventBody;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    public void setEventType(CalcEventType eventType) {
        this.eventType = eventType;
    }

    public String getStringEvent(boolean fullReport, boolean showTimeStamp) {
        StringBuilder text = new StringBuilder();

        if (!fullReport) {
            //если простой вывод - выводим только тип ивента
            if (showTimeStamp) {
                text.append(getTimeStamp().format(formatter)).append(" ");
            }
            text.append(getEventType());
        }

        if (fullReport) {
            if (showTimeStamp) {
                text.append(getTimeStamp().format(formatter)).append(" ");
            }
            //иначе выводим тип и тело ивента
            text.append(getEventType());
            text.append(getEventBody());
        }
        return text.toString();
    }

    public void clearEventBody() {
        eventBody.delete(0, eventBody.length() - 1);
    }
}
