package com.code.kata;

import com.code.kata.impl.LogSourceImpl;

public class Main {
    public static void main(String[] args) {
        
        LogSource logSource = new LogSourceImpl();
        
        LogAggregator logAggregator = new LogAggregator(
            logSource.fetchLogs()
        );
        
        System.out.println(logAggregator.printResult());
    }
}