package com.cosmos.astronomy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.table.TableColumn;
import java.util.NoSuchElementException;
import java.util.Random;


@Controller
public class SpaceExplorerController {


    private final CelestialBodyRepository repository;

    public SpaceExplorerController(CelestialBodyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/stars")
    public String catalogStars(Model model) {
        model.addAttribute("stars", repository.findByBodyType(BodyType.STAR));
        return "catalog-stars";
    }

    @GetMapping("/asteroids")
    public String catalogAsteroids(Model model) {
        model.addAttribute("asteroids", repository.findByBodyType(BodyType.ASTEROID));
        return "catalog-asteroids";
    }

    @GetMapping("/planets")
    public String catalogPlanets(Model model) {
        model.addAttribute("planets", repository.findByBodyType(BodyType.PLANET));
        return "catalog-planets";
    }

    @GetMapping("/bodies/planet/{id}")
    public String showPlanet(@PathVariable Long id, Model model) {
        CelestialBody body = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Planet not found"));

        if (!(body instanceof Planet planet)) {
            throw new ClassCastException("Not a Planet");
        }

        int bgNumber;

        switch (planet.getIdentifier()) {
            case "Марс" -> bgNumber = 11;
            case "Земля" -> bgNumber = 15;
            case "Юпитер" -> bgNumber = 13;
            case "Сатурн" -> bgNumber = 14;
            case "Нептун" -> bgNumber = 12;

            default -> bgNumber = new Random().nextInt(10) + 1;
        }

        model.addAttribute("body", body);
        model.addAttribute("bgNumber", bgNumber);

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