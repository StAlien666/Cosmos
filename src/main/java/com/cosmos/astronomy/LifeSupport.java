package com.cosmos.astronomy;

public interface LifeSupport {

    double WATER_LIQUID_MIN = 0;       // Минимальная температура для жидкой воды (°C)
    double WATER_LIQUID_MAX = 100;     // Максимальная температура для жидкой воды (°C)
    double AMMONIA_LIQUID_MIN = -77.7; // Минимальная температура для жидкого аммиака (°C)
    double AMMONIA_LIQUID_MAX = -33.34; // Максимальная температура для жидкого аммиака (°C)
    double METHANE_LIQUID_MIN = -161.5; // Минимальная температура для жидкого метана (°C)
    double METHANE_LIQUID_MAX = -182.5; // Максимальная температура для жидкого метана (°C)
    double GRAVITY_MIN = 4.905;          // Минимальная гравитация для жизни (м/с²)
    double GRAVITY_MAX = 19.62;          // Максимальная гравитация для жизни (м/с²)
    double CARBON_LIFE_TEMP_MIN = -200; // Минимальная температура для углеродной жизни (°C)
    double CARBON_LIFE_TEMP_MAX = 100;  // Максимальная температура для углеродной

    boolean hasLiquidWater();
    boolean hasOxygenInAtmosphere();
    boolean hasSuitableGravity();
    boolean hasLiquidAmmoniaOrMethane();
    boolean hasSuitableTemperatureForCarbonLife();
    boolean hasSiliconInAtmosphere();
}
