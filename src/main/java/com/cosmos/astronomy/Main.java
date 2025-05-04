package com.cosmos.astronomy;

public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet(
                "Земля",
                6371,
                5514,
                1,
                100,
                1.225,
                101325,
                Atmosphere.AtmosphericElement.NITROGEN,
                15, // surfaceTemperature в °C
                0.000025,
                1,
                false,
                15,
                0,
                Orbit.OrbitType.AROUND_SUN,
                29.78,
                149.6e6
        );
        System.out.println("=== Проверка условий жизни ===");
        System.out.println("Жидкая вода: " + earth.hasLiquidWater());
        System.out.println("Подходящая гравитация: " + earth.hasSuitableGravity());
        System.out.println("Кремний в атмосфере: " + earth.hasSiliconInAtmosphere());
        System.out.println("Тип жизни: " + earth.getLifeType());
    }
}