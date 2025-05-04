package Cosmos;

import java.util.Scanner;

public class SpaceExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание объектов
        Planet earth = new Planet("Земля", 6371, 5514, 9.81, 100, 1.225, 101325,
                Atmosphere.AtmosphericElement.NITROGEN, 288, 0.000025, 1, false, 15, 0,
                Orbit.OrbitType.AROUND_SUN, 29.78, 149.6e6);

        Star sun = new Star("Солнце", 696340, 1408, 274, 0, 0, 0,
                Atmosphere.AtmosphericElement.HYDROGEN, 5778, 0.00001, 14.18, 0,
                Orbit.OrbitType.NONE, 0, 0);

        Asteroid asteroid = new Asteroid("Церера", 473, 2162, Asteroid.AsteroidComposition.CARBONACEOUS,
                "Сфероид", false, Orbit.OrbitType.AROUND_SUN, 17.94, 414.0e6);

        // Меню
        while (true) {
            System.out.println("Выберите небесное тело:");
            System.out.println("1. Земля");
            System.out.println("2. Солнце");
            System.out.println("3. Церера");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayInfo(earth);
                    break;
                case 2:
                    displayInfo(sun);
                    break;
                case 3:
                    displayInfo(asteroid);
                    break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void displayInfo(CelestialBody body) {
        System.out.println("Информация о небесном теле:");
        System.out.println("- Идентификатор: " + body.getIdentifier());
        System.out.println("- Радиус: " + body.getRadius() + " км");
        System.out.println("- Плотность: " + body.getDensity() + " кг/м³");

        if (body instanceof Planet) {
            Planet planet = (Planet) body;
            System.out.println("- Гравитация: " + planet.getGForce() + " м/с²");
            System.out.println("- Атмосфера: " + (planet.hasAtmosphere() ? "Есть" : "Нет"));
            System.out.println("- Подходит для жизни: " + (planet.hasSuitableGravity() && planet.hasLiquidWater() ? "Да" : "Нет"));
        } else if (body instanceof Star) {
            Star star = (Star) body;
            System.out.println("- Температура поверхности: " + star.getSurfaceTemperature() + " K");
            System.out.println("- Светимость: " + star.calculateLuminosity() + " Вт");
            System.out.println("- Спектральный класс: " + star.determineSpectralClass());
        } else if (body instanceof Asteroid) {
            Asteroid asteroid = (Asteroid) body;
            System.out.println("- Состав: " + asteroid.getComposition());
            System.out.println("- Потенциально опасный: " + (asteroid.isPotentiallyHazardous() ? "Да" : "Нет"));
        }
    }
}