package Cosmos;

public abstract class CelestialBody implements Orbit {
    private final String identifier; // Идентификатор объекта String а не int (может содержать буквы и цифры)
    private final double radius;
    private double density;

    private static int counter = 0;

    public CelestialBody(String identifier, double radius, double density) {
        this.identifier = identifier;
        this.radius = radius;
        this.density = density;
        counter++;
    }

    public String getIdentifier() {
        return identifier;
    }

    public double getRadius() {
        return radius;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public static int getCounter() {
        return counter;
    }

    private static double calculateMass(double radius, double density) {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        return density * volume;
    }

}
