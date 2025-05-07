package com.cosmos.astronomy;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CelestialBodyRepository repository;

    public DataInitializer(CelestialBodyRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        //repository.deleteAll();
        // Земля

        OrbitData earthOrbit = new OrbitData(
                Orbit.OrbitType.AROUND_SUN,
                29.78,
                149.6e6
        );

        Planet earth = new Planet(
                "Земля",
                6371,
                5514,
                9.81,
                100,
                1.225,
                101325,
                Atmosphere.AtmosphericElement.NITROGEN,
                15,
                0.000025,
                1,
                false,
                15,
                0,
                earthOrbit
        );
        //repository.save(earth);

        //Солнце

        OrbitData sunOrbit = new OrbitData(
                Orbit.OrbitType.NONE,
                0,
                0
        );
        Star sun = new Star(
                "Солнце",
                696340,
                1408,
                274.0,
                500,
                1.4e-4,
                0.01,
                Atmosphere.AtmosphericElement.HYDROGEN,
                5778,
                0.0001,
                14.18,
                7.25,
                sunOrbit
        );
        //repository.save(sun);

        OrbitData oumuamuaOrbit = new OrbitData(
                Orbit.OrbitType.NONE,
                26.0,
                37_400_000
        );

        Asteroid oumuamua = new Asteroid(
                "1I/2017 U1 (Оумуамуа)",
                0.23,
                2500,
                Asteroid.AsteroidComposition.ICY,
                "Cigar-shaped",
                false,
                oumuamuaOrbit
        );
        //repository.save(oumuamua);
    }
}