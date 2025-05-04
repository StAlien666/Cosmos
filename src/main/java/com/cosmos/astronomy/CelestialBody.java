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