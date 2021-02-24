package service;

import api.service.ICarService;
import model.Car;
import org.junit.Test;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CarServiceTest {
    CarService carService = new CarService(new CarRepository());

    @Test
    public void calculateCostTaxiPark() {

        List<Car> cars = carService.getAll();

        double sumCost = 0;

        for (Car eachCar : cars
        ) {
            sumCost += eachCar.getCost();
        }
        double testCost = new CarService(new CarRepository()).calculateCostTaxiPark();

        assertEquals(sumCost, testCost, 0.0);
    }

    @Test
    public void findCarBySpeed() {
        int minSpeed = 100;
        int maxSpeed = 250;

        ArrayList<Car> carList = (ArrayList<Car>) carService.getAll().stream()
                .filter(x -> x.getSpeed() > minSpeed)
                .filter(x -> x.getSpeed() < maxSpeed)
                .collect(Collectors.toList());

        ArrayList<Car> testCarList = (ArrayList<Car>) new CarService(new CarRepository())
                .findCarBySpeed(100, 250);

        assertEquals(carList.size(), testCarList.size());
    }
}