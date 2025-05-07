package com.cosmos.astronomy;

import com.cosmos.astronomy.Orbit;
import jakarta.persistence.*;
import com.cosmos.astronomy.BodyType;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "body_type")
public abstract class CelestialBody implements Orbit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "body_type", insertable = false, updatable = false)
    private BodyType bodyType;

    @Embedded
    private OrbitData orbitData;


    private String identifier;
    private double radius;
    private double density;

    // Конструктор по умолчанию
    public CelestialBody() {
    }

    // Конструктор с параметрами (без id)
    public CelestialBody(String identifier, double radius, double density) {
        this.identifier = identifier;
        this.radius = radius;
        this.density = density;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    @Override
    public Orbit.OrbitType getOrbitType() {
        return orbitData != null ? orbitData.getOrbitType() : null;
    }

    @Override
    public double getOrbitalSpeed() {
        return orbitData != null ? orbitData.getOrbitalSpeed() : 0;
    }

    @Override
    public double getOrbitalDistance() {
        return orbitData != null ? orbitData.getOrbitalDistance() : 0;
    }

    // Геттер и сеттер для OrbitData
    public OrbitData getOrbitData() {
        return orbitData;
    }

    public void setOrbitData(OrbitData orbitData) {
        this.orbitData = orbitData;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }
}