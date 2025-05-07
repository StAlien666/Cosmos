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

        // Земля
        OrbitData marsOrbit = new OrbitData(
                Orbit.OrbitType.AROUND_SUN,
                24.07,
                227.9e6

        );
        Planet mars = new Planet(
                "Марс",
                3389,
                3933,
                3.71,
                11,
                0.020,
                610,
                Atmosphere.AtmosphericElement.CARBON_DIOXIDE,
                -63,
                0.0000001,
                2,
                false,
                868,
                25.2,
                marsOrbit
        );



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

        OrbitData jupiterOrbit = new OrbitData (
                Orbit.OrbitType.AROUND_SUN,
                13.07,
                778.5e6
        );

        Planet jupiter = new Planet(
                "Юпитер",
                69911,
                1326,
                24.79,
                5000,
                0.16,
                200000,
                Atmosphere.AtmosphericElement.HYDROGEN,
                -145,
                0.0042,
                79,
                true,
                45583,
                3.1,
                jupiterOrbit
        );


        OrbitData saturnOrbit = new OrbitData(
                Orbit.OrbitType.AROUND_SUN,
                9.68,
                1.429e9
        );
        Planet saturn = new Planet(
                "Сатурн",
                58232,
                687,
                10.44,
                3000,
                0.19,
                140000,
                Atmosphere.AtmosphericElement.HYDROGEN,
                -178,
                0.0022,
                83,
                true,
                35500,
                26.7,
                saturnOrbit
        );

        OrbitData neptuneOrbit = new OrbitData(
                Orbit.OrbitType.AROUND_SUN,
                5.43,
                4.498e9
        );
        Planet neptune = new Planet(
                "Нептун",
                24622,
                1638,
                11.15,
                2000,
                1.5,
                1000000,
                Atmosphere.AtmosphericElement.HYDROGEN,
                -214,
                0.0014,
                14,
                true,
                9670,
                28.3,
                neptuneOrbit
        );

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



        OrbitData siriusAOrbit = new OrbitData(
                Orbit.OrbitType.AROUND_SUN,
                46,
                8.6e12
        );
        Star siriusA = new Star(
                "Сириус А",
                1190000,
                0.57,
                8870,
                1200000,
                2e-5,
                0.0005,
                Atmosphere.AtmosphericElement.HYDROGEN,
                9940,
                0.0003,
                16000,
                36,
                siriusAOrbit
        );


        OrbitData betelgeuseOrbit = new OrbitData(
                Orbit.OrbitType.AROUND_SUN,
                30,
                4.5e16
        );
        Star betelgeuse = new Star(
                "Бетельгейзе",
                820000000,
                1e-6,
                0.002,
                1e9,
                1e-10,
                1e-7,
                Atmosphere.AtmosphericElement.HELIUM,
                3300,
                0.00001,
                5000,
                42,
                betelgeuseOrbit
        );

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


        //repository.deleteAll();
        //repository.save(mars);
        //repository.save(earth);
        //repository.save(jupiter);
        //repository.save(saturn);
        //repository.save(neptune);
        //repository.save(sun);
        //repository.save(siriusA);
        //repository.save(betelgeuse);
        //repository.save(oumuamua);

    }
}