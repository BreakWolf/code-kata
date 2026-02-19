package com.code.kata.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogEntry implements Comparable<LogEntry> {
    private LocalDateTime timestamp;
    private LogLevel logLevel;
    private String message;

    public LogEntry(String timestamp, String logLevel, String message) {
        this.timestamp = LocalDateTime.parse(timestamp
            , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.logLevel = LogLevel.valueOf(logLevel);
        this.message = message;
    } 

    public LogEntry(String logstString){
        String[] parts = logstString.split(" ");
        this.timestamp = LocalDateTime.parse(parts[0] + " " + parts[1]
            , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.logLevel = LogLevel.valueOf(parts[2]);
        this.message = String.join(" ", 
                Arrays.copyOfRange(parts, 3, parts.length)
        );
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(LogEntry o) {
        return this.logLevel.compareTo(o.logLevel);
    }
}
