package com.cosmos.astronomy;


public interface Orbit {
    public enum OrbitType {
        AROUND_SUN("Вокруг звезды"),
        AROUND_PLANET("Вокруг планеты"),
        NONE("Нет орбиты");

        private final String displayName;

        OrbitType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }
    OrbitType getOrbitType();
    double getOrbitalSpeed();
    double getOrbitalDistance();

    default double getOrbitalPeriodInEarthYears() {
        double orbitalPeriodSeconds = (2 * Math.PI * getOrbitalDistance()) / (getOrbitalSpeed() * 1000);
        return orbitalPeriodSeconds / 31_536_000;
    }
}
