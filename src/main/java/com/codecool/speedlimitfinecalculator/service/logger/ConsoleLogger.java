package com.codecool.speedlimitfinecalculator.service.logger;

public class ConsoleLogger implements Logger {
    @Override
    public void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    @Override
    public void logError(String message) {
        System.err.println("[ERROR] " + message);
    }
}