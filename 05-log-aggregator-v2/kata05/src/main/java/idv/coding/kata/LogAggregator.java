package idv.coding.kata;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import idv.coding.kata.entities.LogEntry;
import idv.coding.kata.entities.LogLevel;

public class LogAggregator {

    List<LogEntry> logEntries;

    public LogAggregator() {
        this.logEntries = new java.util.ArrayList<>();
    }

    public void addLogEntry(LogEntry logEntry) {
        logEntries.add(logEntry);
    }    

    public void addLogEntries(List<LogEntry> logEntries) {
        this.logEntries.addAll(logEntries);
    }

    public Map<LogLevel, Long> aggregateByLogLevel() {
        return logEntries.stream()
                .collect(Collectors.groupingBy(
                    LogEntry::getLevel
                    , Collectors.counting()));
    }
}
