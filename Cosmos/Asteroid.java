package Cosmos;

public class Asteroid extends CelestialBody {

    private AsteroidComposition composition;
    private String shape;
    private boolean isPotentiallyHazardous;
    private OrbitType orbitType;
    private double orbitalSpeed;
    private double orbitalDistance;

    public Asteroid(String identifier, double radius, double density, AsteroidComposition composition, String shape, boolean isPotentiallyHazardous, OrbitType orbitType, double orbitalSpeed, double orbitalDistance) {
        super(identifier, radius, density);
        this.composition = composition;
        this.shape = shape;
        this.isPotentiallyHazardous = isPotentiallyHazardous;
        this.orbitType = orbitType;
        this.orbitalSpeed = orbitalSpeed;
        this.orbitalDistance = orbitalDistance;
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


    public enum AsteroidComposition {
        STONY,
        METALLIC,
        ICY,
        CARBONACEOUS,
        MIXED
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
