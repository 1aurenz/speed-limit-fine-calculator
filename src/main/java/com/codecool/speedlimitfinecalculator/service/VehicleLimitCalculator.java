package com.codecool.speedlimitfinecalculator.service;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;

public interface VehicleLimitCalculator
{
    int getVehicleLimitByRoadType(VehicleType vehicleType, RoadType roadType);
}
