package com.cosmos.astronomy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;


@Controller
public class SpaceExplorerController {


    private final CelestialBodyRepository repository;

    public SpaceExplorerController(CelestialBodyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("planets", repository.findByBodyType(BodyType.PLANET));
        model.addAttribute("stars", repository.findByBodyType(BodyType.STAR));
        model.addAttribute("asteroids", repository.findByBodyType(BodyType.ASTEROID));
        return "index";
    }

    @GetMapping("/bodies/planet/{id}")
    public String showPlanet(@PathVariable Long id, Model model) {
        CelestialBody body = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Planet not found"));

        if (!(body instanceof Planet)) {
            throw new ClassCastException("Not a Planet");
        }

        model.addAttribute("body", body);
        return "planet-details";
    }

    @GetMapping("/bodies/star/{id}")
    public String showStar(@PathVariable Long id, Model model) {
        CelestialBody body = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Star not found"));

        if (!(body instanceof Star)) {
            throw new ClassCastException("Not a Star");
        }

        model.addAttribute("body", body);
        return "star-details";
    }

    @GetMapping("/bodies/asteroid/{id}")
    public String showAsteroid(@PathVariable Long id, Model model) {
        CelestialBody body = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Asteroid not found"));

        if (!(body instanceof Asteroid)) {
            throw new ClassCastException("Not a asteroid");
        }

        model.addAttribute("body", body);
        return "asteroid-details";
    }
}