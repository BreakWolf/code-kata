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
            "ERROR: 2" + System.lineSeparator() +
            "INFO: 1" + System.lineSeparator() +
            "WARN: 1" + System.lineSeparator()
        );
    }
}