package com.codecool.speedlimitfinecalculator.ui;

import com.codecool.speedlimitfinecalculator.model.RoadType;
import com.codecool.speedlimitfinecalculator.model.VehicleType;
import com.codecool.speedlimitfinecalculator.service.SpeedLimitFineCalculator;
import com.codecool.speedlimitfinecalculator.service.logger.ConsoleLogger;
import com.codecool.speedlimitfinecalculator.service.logger.Logger;

import java.util.Scanner;

public class FineCalculatorUi {
    private final SpeedLimitFineCalculator speedLimitFineCalculator;
    private final Logger logger = new ConsoleLogger();

    public FineCalculatorUi(SpeedLimitFineCalculator speedLimitFineCalculator, Logger logger) {
        this.speedLimitFineCalculator = speedLimitFineCalculator;
    }

    public void run() {
        logger.logInfo("FineCalculatorUi is running.");
        greetUser();

        VehicleType vehicleTypeEnum = selectVehicleType();
        RoadType roadTypeEnum = selectRoadType();
        int speed = getSpeed();

        double fine = speedLimitFineCalculator.calculateSpeedLimitFine(vehicleTypeEnum, roadTypeEnum, speed);

        if (fine == 0) {
            logger.logInfo("You are within speed limits! No fine applies.");
        } else {
            logger.logInfo("Your fine is " + fine + " CodeCoins :(");
        }

        logFineCalculation(vehicleTypeEnum, roadTypeEnum, speed, fine);
    }

    private VehicleType selectVehicleType() {
        Scanner scanner = new Scanner(System.in);
        logger.logInfo("Select vehicle type (Car, Bus, or Truck): ");
        String input = scanner.nextLine();

        try {
            return VehicleType.valueOf(input);
        } catch (IllegalArgumentException e) {
            logger.logError("Invalid vehicle type. Please try again.");
            return selectVehicleType();
        }
    }

    private RoadType selectRoadType() {
        Scanner scanner = new Scanner(System.in);
        logger.logInfo("Select road type (Urban, Main Road, or Highway): ");
        String input = scanner.nextLine();

        try {
            return RoadType.valueOf(input);
        } catch (IllegalArgumentException e) {
            logger.logError("Invalid road type. Please try again.");
            return selectRoadType();
        }
    }

    private int getSpeed() {
        Scanner scanner = new Scanner(System.in);
        logger.logInfo("Enter vehicle speed (in km/h): ");

        while (!scanner.hasNextInt()) {
            logger.logError("Invalid input. Please enter a valid speed (in km/h): ");
            scanner.next(); // consume the invalid input
        }

        return scanner.nextInt();
    }

    private void greetUser() {
        logger.logInfo("Hi! You were on the road again, but you were a bit too fast, weren't you? " +
                "No worries, let's see how much it will cost you!");
    }

    private void logFineCalculation(VehicleType vehicleType, RoadType roadType, int speed, double fine) {
        String logMessage = String.format("Fine calculation - Vehicle Type: %s, Road Type: %s, Speed: %d km/h, Fine: %.2f",
                vehicleType, roadType, speed, fine);
        logger.logInfo(logMessage);
    }
}