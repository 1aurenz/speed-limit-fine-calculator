package com.codecool.speedlimitfinecalculator;

import com.codecool.speedlimitfinecalculator.service.*;
import com.codecool.speedlimitfinecalculator.service.logger.ConsoleLogger;
import com.codecool.speedlimitfinecalculator.service.logger.Logger;
import com.codecool.speedlimitfinecalculator.ui.FineCalculatorUi;

public class Application {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        VehicleLimitProvider vehicleLimitProvider = new VehicleLimitProviderImpl();
        VehicleLimitCalculator vehicleLimitCalculator = new VehicleLimitCalculatorImpl(vehicleLimitProvider);
        SpeedLimitFineCalculator speedLimitFineCalculator = new SpeedLimitFineCalculatorImpl(vehicleLimitCalculator);
        FineCalculatorUi fineCalculatorUi = new FineCalculatorUi(speedLimitFineCalculator, logger);
        fineCalculatorUi.run();
    }
}
