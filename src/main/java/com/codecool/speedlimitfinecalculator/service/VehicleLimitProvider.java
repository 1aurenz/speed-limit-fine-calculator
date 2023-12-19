package com.codecool.speedlimitfinecalculator.service;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;

public interface VehicleLimitProvider {
    int getSpeedLimit(VehicleType vehicleType, RoadType roadType);
}
