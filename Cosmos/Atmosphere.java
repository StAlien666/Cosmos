package Cosmos;

public interface Atmosphere {
    double getAtmosphericPressure(); // Атмосферное давление в Паскалях (Па)
    double getSurfaceTemperature(); // Температура на поверхности в Кельвинах (K)
    double getAtmosphereHeight(); // Высота атмосферы в км
    double getAtmosphereDensity(); // Плотность атмосферы в кг/м³
    double getGForce(); // Сила гравитации на поверхности в м/с²

    default boolean hasAtmosphere() {
        return getAtmosphericPressure() > 0;
    }

    AtmosphericElement getPrimaryElement(); //основной элемент атмосферы

    enum AtmosphericElement {
        HYDROGEN,
        HELIUM,
        CARBON,
        NITROGEN,
        OXYGEN,
        SILICON,
        IRON,
        MAGNESIUM,
        CALCIUM,
        SODIUM,
        CARBON_DIOXIDE,
        METHANE,
        AMMONIA,
        SULFUR_DIOXIDE,
        ARGON,
        OTHER
    }
}
