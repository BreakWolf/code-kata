package com.code.kata;

public class Main {
    public static void main(String[] args) {
        
        LogSource logSource = new LogSourceImpl();
        
        LogAggregator logAggregator = new LogAggregator(
            logSource.fetchLogs()
        );
        
        System.out.println(logAggregator.printResult());
    }
}