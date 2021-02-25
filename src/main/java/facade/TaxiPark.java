package facade;

import ui.ConsoleInput;
import api.ui.IConsolInput;
import model.Car;
import repository.CarRepository;
import api.repository.IRepository;
import service.CarService;
import api.service.ICarService;

import java.util.List;
import java.util.logging.Logger;

public class TaxiPark {

    private static TaxiPark instance;
    private static final Logger log = Logger.getLogger(TaxiPark.class.getName());
    private final IRepository carRepository = new CarRepository();
    private final ICarService carService = new CarService(carRepository);
    private final IConsolInput consolInput = new ConsoleInput();


    private TaxiPark() {

    }

    public static TaxiPark getInstance() {
        log.info("IN TaxiPark getInstance() : object taxiPark was created");

        if (instance == null) {
            instance = new TaxiPark();

        }
        return instance;

    }

    public void prepareAllData() {
        carService.add(new Car("Wv", 2000, 10, 180));
        carService.add(new Car("BMW", 4000, 12, 200));
        carService.add(new Car("Geely", 10000, 13, 170));
        carService.add(new Car("Audi", 12000, 14, 220));
    }

    public void getAll() {
        carService.getAll().forEach(System.out::println);
    }

    public List<Car> sortByFuelConsumption() {
        return carService.sortByFuelConsumption();
    }

    public List<Car> findCarBySpeed() {

        System.out.println("Please enter minimal speed ");
        int minSpeed = consolInput.consoleInputing();

        System.out.println("Please enter maximal speed ");
        int maxSpeed = consolInput.consoleInputing();

        return carService.findCarBySpeed(minSpeed, maxSpeed);
    }

    public double calculateCostAllCars() {
        return carService.calculateCostAllCars();
    }

}
