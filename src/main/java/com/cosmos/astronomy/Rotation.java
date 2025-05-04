package com.cosmos.astronomy;

public interface Rotation {
    double getRotationSpeed();
    double getRotationAngle();

    default double getRotationPeriodInEarthDays() {
        double degreesPerHour = getRotationSpeed();

        if (degreesPerHour == 0) {
            return Double.POSITIVE_INFINITY;
        }

        double rotationPeriodHours = 360 / degreesPerHour;
        return rotationPeriodHours / 24;
    }
}
