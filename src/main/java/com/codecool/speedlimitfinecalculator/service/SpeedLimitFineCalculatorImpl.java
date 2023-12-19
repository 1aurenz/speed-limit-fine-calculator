package com.codecool.speedlimitfinecalculator.service;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;

public class SpeedLimitFineCalculatorImpl implements SpeedLimitFineCalculator {
    private final VehicleLimitCalculator vehicleLimitCalculator;

    public SpeedLimitFineCalculatorImpl(VehicleLimitCalculator vehicleLimitCalculator) {
        this.vehicleLimitCalculator = vehicleLimitCalculator;
    }

    @Override
    public double calculateSpeedLimitFine(VehicleType vehicleType, RoadType roadType, double actualSpeed) {
        int limit = vehicleLimitCalculator.getVehicleLimitByRoadType(vehicleType, roadType);
        double excessSpeed = actualSpeed - limit;

        if (excessSpeed <= 0) {
            return 0;
        } else {
            return excessSpeed*4;
        }
    }
}