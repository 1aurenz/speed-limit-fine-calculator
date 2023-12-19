package com.codecool.speedlimitfinecalculator.service;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;

public class VehicleLimitCalculatorImpl implements VehicleLimitCalculator {
    private final VehicleLimitProvider vehicleLimitProvider;

    public VehicleLimitCalculatorImpl(VehicleLimitProvider vehicleLimitProvider) {
        this.vehicleLimitProvider = vehicleLimitProvider;
    }

    @Override
    public int getVehicleLimitByRoadType(VehicleType vehicleType, RoadType roadType) {
        return vehicleLimitProvider.getSpeedLimit(vehicleType, roadType);
    }
}

