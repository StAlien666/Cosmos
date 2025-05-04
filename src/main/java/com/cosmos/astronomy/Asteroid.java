package com.cosmos.astronomy;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ASTEROID")

public class Asteroid extends CelestialBody {

    private AsteroidComposition composition;
    private String shape;
    private boolean isPotentiallyHazardous;

    public Asteroid() {
    }

    public Asteroid(String identifier, double radius, double density, AsteroidComposition composition, String shape, boolean isPotentiallyHazardous, OrbitData orbitData) {
        super(identifier, radius, density);
        this.composition = composition;
        this.shape = shape;
        this.isPotentiallyHazardous = isPotentiallyHazardous;
        super.setOrbitData(orbitData);
    }

    public AsteroidComposition getComposition() {
        return composition;
    }

    public void setComposition(AsteroidComposition composition) {
        this.composition = composition;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public boolean isPotentiallyHazardous() {
        return isPotentiallyHazardous;
    }

    public void setPotentiallyHazardous(boolean potentiallyHazardous) {
        isPotentiallyHazardous = potentiallyHazardous;
    }



    public enum AsteroidComposition {
        STONY("Каменный"),
        METALLIC("Металлический"),
        ICY("Ледяной"),
        CARBONACEOUS("Углеродистый"),
        MIXED("Смешанный");

        private final String displayName;

        AsteroidComposition(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public double calculateMass() {
        double radiusInMeters = getRadius() * 1000;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radiusInMeters, 3);
        return getDensity() * volume;
    }


    public double calculateKineticEnergy() {
        double mass = calculateMass();
        return 0.5 * mass * Math.pow(getOrbitalSpeed(), 2);
    }

    public boolean isPotentiallyHazardousToEarth() {
        double earthOrbitDistance = 149.6e6;
        double safeDistance = 0.05 * earthOrbitDistance; //0.05 а.е.
        return getOrbitalDistance() < safeDistance && getRadius() > 0.140;
    }

}
