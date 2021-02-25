package service;

import api.service.ICarService;
import model.Car;
import org.junit.*;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarServiceTest {

    private final ICarService carService = new CarService(new CarRepository());


    @Before()
    public void setUp() {

        carService.add(new Car("car1", 100.1, 10.1, 100));
        carService.add(new Car("car2", 200.2, 20.2, 200));
        carService.add(new Car("car3", 300.3, 30.3, 300));
        carService.add(new Car("car4", 400.4, 40.4, 400));

    }

    @After
    public void down(){
        carService.getAll().forEach(carService::delete);
    }

    @Test
    public void calculateCostAllCars() {

        double costExpected = 1000.2;

        double actualCost =carService.calculateCostAllCars();

        assertEquals(costExpected, actualCost, 1);

    }

    @Test
    public void findCarBySpeed() {

        int minSpeed = 200;
        int maxSpeed = 300;

        List<Car> carExpected = new ArrayList<>();
        carExpected.add(new Car("car2", 200.2, 20.2, 200));
        carExpected.add(new Car("car3", 300.3, 30.3, 300));

        List<Car> carActual = carService.findCarBySpeed(minSpeed, maxSpeed);

        assertEquals(carExpected, carActual);

    }
    @Test
    public void sortByFuelConsumption() {

        List<Car> carExpected = new ArrayList<>();

        carExpected.add(new Car("car1", 100.1, 10.1, 100));
        carExpected.add(new Car("car2", 200.2, 20.2, 200));
        carExpected.add(new Car("car3", 300.3, 30.3, 300));
        carExpected.add(new Car("car4", 400.4, 40.4, 400));

        List<Car> carActual = carService.sortByFuelConsumption();

        assertEquals(carExpected, carActual);

    }
}