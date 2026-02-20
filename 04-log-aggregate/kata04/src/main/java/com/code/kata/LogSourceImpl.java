package com.code.kata;

import java.util.List;

public class LogSourceImpl implements LogSource {

    @Override
    public List<String> fetchLogs() {
        List<String> logs = List.of(
            "2026-02-16 10:15:32 INFO User login success",
            "2026-02-16 10:15:35 ERROR Database timeout",
            "2026-02-16 10:16:02 WARN Memory usage high",
            "2026-02-16 10:16:10 ERROR Connection refused"
        );
        
        return logs;
    }
}