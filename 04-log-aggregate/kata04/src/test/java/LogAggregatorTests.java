import org.junit.Test;

import com.code.kata.LogAggregator;

public class LogAggregatorTests {

    @Test
    public void test_print_result(){
        String logString = "" +
"2026-02-16 10:15:32 INFO User login success" + System.lineSeparator() +
"2026-02-16 10:15:35 ERROR Database timeout" + System.lineSeparator() +
"2026-02-16 10:16:02 WARN Memory usage high" + System.lineSeparator() +
"2026-02-16 10:16:10 ERROR Connection refused" + System.lineSeparator() +
"";
        LogAggregator logAggregator = new LogAggregator(logString);
        assert logAggregator.printResult().equals(
            "ERROR"+ "\t"+"count=2 first=10:15:35 last=10:16:10" + System.lineSeparator() +
            "WARN"+ "\t"+"count=1 first=10:16:02 last=10:16:02" + System.lineSeparator() +
            "INFO"+ "\t"+"count=1 first=10:15:32 last=10:15:32" + System.lineSeparator() 
        );
    }

    @Test
    public void print_when_log_is_empty(){
        LogAggregator logAggregator = new LogAggregator();
        assert logAggregator.printResult().equals("");
    }
}