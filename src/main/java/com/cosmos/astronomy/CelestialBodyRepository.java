package com.cosmos.astronomy;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.cosmos.astronomy.BodyType;

public interface CelestialBodyRepository extends JpaRepository<CelestialBody, Long> {
    List<CelestialBody> findByBodyType(BodyType bodyType);
}