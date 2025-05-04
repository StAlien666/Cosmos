package com.cosmos.astronomy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import com.cosmos.astronomy.Atmosphere.AtmosphericElement;
import com.cosmos.astronomy.Orbit;

@Entity
@DiscriminatorValue("STAR")

public class Star extends CelestialBody implements Atmosphere, MagneticField, Rotation {
    private double gForce;
    private double atmosphereHeight;
    private double atmosphereDensity;
    private double AtmosphericPressure;
    private AtmosphericElement primaryElement;
    private double surfaceTemperature;
    private double magneticFieldStrength;
    private double rotationSpeed;
    private double rotationAngle;
    private Orbit.OrbitType orbitType;
    private double orbitalSpeed;
    private double orbitalDistance;

    public Star() {
    }

    public Star(String identifier, double radius, double density, double gForce, double atmosphereHeight, double atmosphereDensity, double atmosphericPressure, AtmosphericElement primaryElement, double surfaceTemperature, double magneticFieldStrength, double rotationSpeed, double rotationAngle, OrbitType orbitType, double orbitalSpeed, double orbitalDistance) {
        super(identifier, radius, density);
        this.gForce = gForce;
        this.atmosphereHeight = atmosphereHeight;
        this.atmosphereDensity = atmosphereDensity;
        AtmosphericPressure = atmosphericPressure;
        this.primaryElement = primaryElement;
        this.surfaceTemperature = surfaceTemperature;
        this.magneticFieldStrength = magneticFieldStrength;
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
        return AtmosphericPressure;
    }

    public void setAtmosphericPressure(double atmosphericPressure) {
        AtmosphericPressure = atmosphericPressure;
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

    private static final double STEFAN_BOLTZMANN_CONSTANT = 5.67e-8;

    // светимость
    public double calculateLuminosity() {
        double radiusInMeters = getRadius() * 1000; // Переводим радиус в метры
        return 4 * Math.PI * Math.pow(radiusInMeters, 2) * STEFAN_BOLTZMANN_CONSTANT * Math.pow(getSurfaceTemperature(), 4);
    }

    public double getLuminosity() {
        return calculateLuminosity();
    }

    public enum SpectralClass {
        O,  // Голубые звезды
        B,  // Бело-голубые звезды
        A,  // Белые звезды
        F,  // Желто-белые звезды
        G,  // Желтые звезды
        K,  // Оранжевые звезды
        M   // Красные звезды
    }

    public SpectralClass determineSpectralClass() {
        double temperature = getSurfaceTemperature();

        if (temperature >= 30_000) {
            return SpectralClass.O;
        } else if (temperature >= 10_000) {
            return SpectralClass.B;
        } else if (temperature >= 7_500) {
            return SpectralClass.A;
        } else if (temperature >= 6_000) {
            return SpectralClass.F;
        } else if (temperature >= 5_000) {
            return SpectralClass.G;
        } else if (temperature >= 3_500) {
            return SpectralClass.K;
        } else {
            return SpectralClass.M;
        }
    }

    public SpectralClass getSpectralClass() {
        return determineSpectralClass();
    }

}