package com.cosmos.astronomy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PLANET")
public class Planet extends CelestialBody implements Atmosphere, MagneticField, Rotation, LifeSupport {
    private double gForce;
    private double atmosphereHeight;
    private double atmosphereDensity;
    private double atmosphericPressure;
    private AtmosphericElement primaryElement;
    private double surfaceTemperature;
    private double magneticFieldStrength;
    private int numberOfMoons;
    private boolean hasRings;
    private double rotationSpeed;
    private double rotationAngle;
    private Orbit.OrbitType orbitType;
    private double orbitalSpeed;
    private double orbitalDistance;

    public Planet() {
    }


    public Planet(String identifier, double radius, double density, double gForce, double atmosphereHeight,
                  double atmosphereDensity, double atmosphericPressure, AtmosphericElement primaryElement,
                  double surfaceTemperature, double magneticFieldStrength, int numberOfMoons, boolean hasRings,
                  double rotationSpeed, double rotationAngle, OrbitType orbitType, double orbitalSpeed,
                  double orbitalDistance) {
        super(identifier, radius, density);
        this.gForce = gForce;
        this.atmosphereHeight = atmosphereHeight;
        this.atmosphereDensity = atmosphereDensity;
        this.atmosphericPressure = atmosphericPressure;
        this.primaryElement = primaryElement;
        this.surfaceTemperature = surfaceTemperature;
        this.magneticFieldStrength = magneticFieldStrength;
        this.numberOfMoons = numberOfMoons;
        this.hasRings = hasRings;
        this.rotationSpeed = rotationSpeed;
        this.rotationAngle = rotationAngle;
        this.orbitType = orbitType;
        this.orbitalSpeed = orbitalSpeed;
        this.orbitalDistance = orbitalDistance;
    }

    @Override
    public double getGForce() {
        return gForce;
    }

    public void setGForce(double gForce) {
        this.gForce = gForce;
    }

    @Override
    public double getAtmosphereHeight() {
        return atmosphereHeight;
    }

    public void setAtmosphereHeight(double atmosphereHeight) {
        this.atmosphereHeight = atmosphereHeight;
    }

    @Override
    public double getAtmosphereDensity() {
        return atmosphereDensity;
    }

    public void setAtmosphereDensity(double atmosphereDensity) {
        this.atmosphereDensity = atmosphereDensity;
    }

    @Override
    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(double atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    @Override
    public AtmosphericElement getPrimaryElement() {
        return primaryElement;
    }

    public void setPrimaryElement(AtmosphericElement primaryElement) {
        this.primaryElement = primaryElement;
    }

    @Override
    public double getSurfaceTemperature() {
        return surfaceTemperature;
    }

    public void setSurfaceTemperature(double surfaceTemperature) {
        this.surfaceTemperature = surfaceTemperature;
    }

    @Override
    public boolean hasMagneticField() {
        return magneticFieldStrength > 0;
    }

    @Override
    public double getMagneticFieldStrength() {
        return magneticFieldStrength;
    }

    public void setMagneticFieldStrength(double magneticFieldStrength) {
        this.magneticFieldStrength = magneticFieldStrength;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    public boolean isHasRings() {
        return hasRings;
    }

    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    @Override
    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(double rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public double getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    @Override
    public OrbitType getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(OrbitType orbitType) {
        this.orbitType = orbitType;
    }

    @Override
    public double getOrbitalSpeed() {
        return orbitalSpeed;
    }

    public void setOrbitalSpeed(double orbitalSpeed) {
        this.orbitalSpeed = orbitalSpeed;
    }

    @Override
    public double getOrbitalDistance() {
        return orbitalDistance;
    }

    public void setOrbitalDistance(double orbitalDistance) {
        this.orbitalDistance = orbitalDistance;
    }

    @Override
    public boolean hasSiliconInAtmosphere() {
        return getPrimaryElement() == AtmosphericElement.SILICON;
    }


    @Override
    public boolean hasOxygenInAtmosphere() {
        return getPrimaryElement() == AtmosphericElement.OXYGEN;
    }

    @Override
    public boolean hasLiquidWater() {
        double temperature = getSurfaceTemperature();
        return temperature > LifeSupport.WATER_LIQUID_MIN && temperature < LifeSupport.WATER_LIQUID_MAX;
    }

    @Override
    public boolean hasSuitableGravity() {
        double gForce = getGForce();
        return gForce > LifeSupport.GRAVITY_MIN && gForce < LifeSupport.GRAVITY_MAX;
    }

    @Override
    public boolean hasLiquidAmmoniaOrMethane() {
        double temperature = getSurfaceTemperature();
        return (temperature > LifeSupport.AMMONIA_LIQUID_MIN && temperature < LifeSupport.AMMONIA_LIQUID_MAX) ||
                (temperature > LifeSupport.METHANE_LIQUID_MIN && temperature < LifeSupport.METHANE_LIQUID_MAX);
    }

    @Override
    public boolean hasSuitableTemperatureForCarbonLife() {
        double temperature = getSurfaceTemperature();
        return temperature > LifeSupport.CARBON_LIFE_TEMP_MIN && temperature < LifeSupport.CARBON_LIFE_TEMP_MAX;
    }


    public LifeType getLifeType() {
        boolean i = false;
        if (hasLiquidWater() && hasSuitableGravity()) {
            return LifeType.PROTEIN;
        } else if (hasSiliconInAtmosphere()) {
            return LifeType.CARBON;
        }
        return null;
    }

}
