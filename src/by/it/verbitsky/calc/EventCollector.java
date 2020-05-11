package by.it.verbitsky.calc;

import java.util.ArrayList;
import java.util.List;

class EventCollector {
    public int currentEventIndex = -1;

    private List<CalcEvent> events = new ArrayList<>(64);

    public void addEvent(CalcEvent event) {
        currentEventIndex++;
        events.add(event);
    }

    public void appendCurrentEventBody(String body) {
        getCurrentEvent().getEventBody().append(" ").append(body);
    }

    public void addSystemStartEvent() {
        currentEventIndex++;
        events.add(new CalcEvent(new CalcEventType().setSystemEventType("Start"), "starting program"));
    }

    public void addSystemEndEvent() {
        currentEventIndex++;
        events.add(new CalcEvent(new CalcEventType().setSystemEventType("End"), "end program"));
    }

    public List<CalcEvent> getEvents() {
        return events;
    }

    public CalcEvent getCurrentEvent() {
        return events.get(currentEventIndex);
    }

    public String getStartTimeStamp() {
        return events.get(0).getTimeStamp().format(CalcEvent.formatter);
    }

    public String getEndTimeStamp() {
        return events.get(currentEventIndex).getTimeStamp().format(CalcEvent.formatter);
    }

    public int getErrorEventsCount() {
        int i = 0;
        for (CalcEvent event : events) {
            if (event.getEventType().getErrorType() != null) {
                i++;
            }
        }
        return i;
    }

    public int getEventsCount() {
        int i = 0;
        for (CalcEvent event : events) {
            if (event.getEventType().getErrorType() == null) {
                i++;
            }
        }
        return i;
    }


}

