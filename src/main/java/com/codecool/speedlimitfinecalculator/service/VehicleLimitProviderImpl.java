package com.codecool.speedlimitfinecalculator.service;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;

public class VehicleLimitProviderImpl implements VehicleLimitProvider {
    @Override
    public int getSpeedLimit(VehicleType vehicleType, RoadType roadType) {
        return switch (vehicleType) {
            case Car -> getCarSpeedLimit(roadType);
            case Bus -> getBusSpeedLimit(roadType);
            case Truck -> getTruckSpeedLimit(roadType);
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }

    private int getCarSpeedLimit(RoadType roadType) {
        return switch (roadType) {
            case Urban -> 50;
            case MainRoad -> 90;
            case Highway -> 130;
            default -> throw new IllegalArgumentException("Invalid road type");
        };
    }

    private int getBusSpeedLimit(RoadType roadType) {
        return switch (roadType) {
            case Urban -> 50;
            case MainRoad -> 70;
            case Highway -> 100;
            default -> throw new IllegalArgumentException("Invalid road type");
        };
    }

    private int getTruckSpeedLimit(RoadType roadType) {
        return switch (roadType) {
            case Urban -> 50;
            case MainRoad -> 70;
            case Highway -> 80;
            default -> throw new IllegalArgumentException("Invalid road type");
        };
    }
}
