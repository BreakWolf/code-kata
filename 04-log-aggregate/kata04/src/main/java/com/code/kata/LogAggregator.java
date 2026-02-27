package com.code.kata;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.code.kata.entities.LogEntry;
import com.code.kata.entities.LogLevel;

public class LogAggregator {
    private List<LogEntry> logEntries;

    public LogAggregator(List<String> logStrings) {
        parseLogStringToEntry(logStrings);
    }

    public LogAggregator(String logString) {
        String[] logStrings = logString.split(System.lineSeparator());
        logEntries = Arrays.stream(logStrings)
                .map(LogEntry::new)
                .collect(Collectors.toList());
    }

    public LogAggregator() {    }


    public String aggregate(List<String> logStrings, Duration timeWindow) {
        // Implementation for aggregation logic based on time window
        parseLogStringToEntry(logStrings);
        List<LogEntry> filteredEntries = logEntries.stream()
                .filter(entry -> Duration.between(entry.getTimestamp(), logEntries.get(0).getTimestamp()).compareTo(timeWindow) <= 0)
                .collect(Collectors.toList());
        return "";
    }

    void parseLogStringToEntry(List<String> logStrings){
        this.logEntries = logStrings.stream()
                .map(LogEntry::new)
                .collect(Collectors.toList());
    }

    public String printResult(){
        if(logEntries == null 
            || logEntries.isEmpty()){
             return "";
        }

        StringBuilder result = new StringBuilder();
        logEntries.stream()
            .collect(Collectors.groupingBy(LogEntry::getLogLevel))
            .entrySet().stream()
            .sorted(Map.Entry.<LogLevel, List<LogEntry>>comparingByKey().reversed())
            .forEach(entry -> {
                List<LogEntry> sortedEntries = entry.getValue()
                    .stream()
                    .sorted((a, b) -> a.getTimestamp()
                        .compareTo(b.getTimestamp()))
                    .collect(Collectors.toList());
                LogEntry firsEntry = sortedEntries.get(0);
                LogEntry lastEntry = sortedEntries.get(sortedEntries.size() - 1);

                result.append(entry.getKey() + "\t" 
                    + "count=" + entry.getValue().size()
                    + " first=" + firsEntry.getTimestamp().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                    + " last=" + lastEntry.getTimestamp().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                    + System.lineSeparator());
            });
        return result.toString();
    }

}
