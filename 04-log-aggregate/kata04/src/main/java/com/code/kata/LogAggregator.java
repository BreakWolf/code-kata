package com.code.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.code.kata.entities.LogEntry;

public class LogAggregator {
    private List<LogEntry> logEntries;

    public LogAggregator(String logString) {
        String[] logStrings = logString.split(System.lineSeparator());
        logEntries = Arrays.stream(logStrings)
                .map(LogEntry::new)
                .collect(Collectors.toList());
    }

    public String printResult(){
        StringBuilder result = new StringBuilder();
        logEntries.stream()
            .collect(Collectors.groupingBy(LogEntry::getLogLevel))
            .forEach((logLevel, entries) -> {
                result.append(logLevel + ": " + entries.size() + System.lineSeparator());
            });
        return result.toString();
    }

}
