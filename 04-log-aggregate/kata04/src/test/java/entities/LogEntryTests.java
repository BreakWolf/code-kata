package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.code.kata.entities.LogEntry;

public class LogEntryTests {
   @Test
   public void test_get_log_level(){
      LogEntry logEntry = new LogEntry("2026-02-16 10:15:32 INFO User login success");
      assertEquals(com.code.kata.entities.LogLevel.INFO, logEntry.getLogLevel());
   } 
}
