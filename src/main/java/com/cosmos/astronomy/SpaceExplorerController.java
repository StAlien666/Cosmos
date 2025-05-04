package com.cosmos.astronomy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        Planet planet = (Planet) repository.findById(id).orElseThrow();
        model.addAttribute("body", planet);
        return "planet-details";
    }

    @GetMapping("/bodies/star/{id}")
    public String showStar(@PathVariable Long id, Model model) {
        Star star = (Star) repository.findById(id).orElseThrow();
        model.addAttribute("body", star);
        return "star-details";
    }

    @GetMapping("/bodies/asteroid/{id}")
    public String showAsteroid(@PathVariable Long id, Model model) {
        Asteroid asteroid = (Asteroid) repository.findById(id).orElseThrow();
        model.addAttribute("body", asteroid);
        return "asteroid-details";
    }
}