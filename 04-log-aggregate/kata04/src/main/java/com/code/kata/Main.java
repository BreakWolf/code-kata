package com.code.kata;

public class Main {
    public static void main(String[] args) {
        
        String logString = "" +
"2026-02-16 10:15:32 INFO User login success" + System.lineSeparator() +
"2026-02-16 10:15:35 ERROR Database timeout" + System.lineSeparator() +
"2026-02-16 10:16:02 WARN Memory usage high" + System.lineSeparator() +
"2026-02-16 10:16:10 ERROR Connection refused" + System.lineSeparator() +
"";
        LogAggregator logAggregator = new LogAggregator(logString);
        
        System.out.println(logAggregator.printResult());
    }
}