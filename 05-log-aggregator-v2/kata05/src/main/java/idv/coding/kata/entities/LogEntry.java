package idv.coding.kata.entities;

import java.time.LocalDateTime;

public class LogEntry {
    private LocalDateTime timestamp;
    private LogLevel level; // INFO, WARN, ERROR 
    private String service;
    private String message;


    // Constructor to parse log string and initialize fields
    // format: timestamp|level|service|message
    public LogEntry(String logString) {
        String[] parts = logString.split("\\|", 4);
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid log entry format");
        }
        this.timestamp = LocalDateTime.parse(parts[0]);
        this.level = LogLevel.valueOf(parts[1]);
        this.service = parts[2];
        this.message = parts[3];
    }

    public LogLevel getLevel() {
        return level;
    }
}