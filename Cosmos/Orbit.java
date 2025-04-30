package Cosmos;


public interface Orbit {
    enum OrbitType {
        AROUND_SUN,
        AROUND_PLANET,
        NONE
    }
    OrbitType getOrbitType();
    double getOrbitalSpeed();
    double getOrbitalDistance();

    default double getOrbitalPeriodInEarthYears() {
        double orbitalPeriodSeconds = (2 * Math.PI * getOrbitalDistance()) / (getOrbitalSpeed() * 1000);
        return orbitalPeriodSeconds / 31_536_000;
    }
}
