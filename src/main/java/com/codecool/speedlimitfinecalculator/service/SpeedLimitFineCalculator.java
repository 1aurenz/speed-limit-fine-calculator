package com.codecool.speedlimitfinecalculator.service;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;

public interface SpeedLimitFineCalculator
{
    double calculateSpeedLimitFine(VehicleType vehicleType, RoadType roadType, double actualSpeed);
}
