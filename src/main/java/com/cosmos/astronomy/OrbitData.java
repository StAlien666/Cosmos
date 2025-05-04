package com.cosmos.astronomy;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import jakarta.persistence.Column;

@Embeddable
public class OrbitData {

    @Enumerated(EnumType.STRING)
    @Column(name = "orbit_type", length = 20)
    private Orbit.OrbitType orbitType;

    @Column(name = "orbital_speed")
    private double orbitalSpeed; // в км/с

    @Column(name = "orbital_distance")
    private double orbitalDistance; // в км

    // Конструкторы
    public OrbitData() {
    }

    public OrbitData(Orbit.OrbitType orbitType, double orbitalSpeed, double orbitalDistance) {
        this.orbitType = orbitType;
        this.orbitalSpeed = orbitalSpeed;
        this.orbitalDistance = orbitalDistance;
    }

    // Геттеры и сеттеры
    public Orbit.OrbitType getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(Orbit.OrbitType orbitType) {
        this.orbitType = orbitType;
    }

    public double getOrbitalSpeed() {
        return orbitalSpeed;
    }

    public void setOrbitalSpeed(double orbitalSpeed) {
        this.orbitalSpeed = orbitalSpeed;
    }

    public double getOrbitalDistance() {
        return orbitalDistance;
    }

    public void setOrbitalDistance(double orbitalDistance) {
        this.orbitalDistance = orbitalDistance;
    }
}