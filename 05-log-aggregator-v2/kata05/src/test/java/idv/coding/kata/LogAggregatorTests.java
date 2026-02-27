package idv.coding.kata;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import idv.coding.kata.entities.LogEntry;
import idv.coding.kata.entities.LogLevel;

public class LogAggregatorTests {

    @Test
    public void phase1_loglevel_couting() {
        ArrayList<LogEntry> logEntries = new ArrayList<>();
        logEntries.add(new LogEntry("2026-02-20T10:15:30|INFO|order-service|create order success"));
        logEntries.add(new LogEntry("2026-02-20T10:16:10|ERROR|payment-service|payment failed"));
        logEntries.add(new LogEntry("2026-02-20T10:16:45|WARN|order-service|retry create order"));
        logEntries.add(new LogEntry("2026-02-20T10:17:05|INFO|user-service|user login"));
        logEntries.add(new LogEntry("2026-02-20T10:17:20|ERROR|order-service|order timeout"));
        logEntries.add(new LogEntry("2026-02-20T10:18:00|INFO|payment-service|payment retry success"));
        logEntries.add(new LogEntry("2026-02-20T10:18:30|WARN|user-service|password attempt failed"));
        logEntries.add(new LogEntry("2026-02-20T10:19:00|ERROR|payment-service|payment timeout"));
        logEntries.add(new LogEntry("2026-02-20T10:19:30|INFO|order-service|order completed"));


        LogAggregator logAggregator = new LogAggregator();
        logAggregator.addLogEntries(logEntries);

        Map<LogLevel, Long> result = logAggregator.aggregateByLogLevel();
        assert result.get(LogLevel.INFO) == 4;
        assert result.get(LogLevel.ERROR) == 3;            
        assert result.get(LogLevel.WARN) == 2;
    }
}
