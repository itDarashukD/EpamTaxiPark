package service;

import ui.ConsoleInput;
import api.service.ICarService;
import model.Car;
import api.repository.IRepository;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService implements ICarService {

    private final Logger log = Logger.getLogger(ConsoleInput.class.getName());
    private final IRepository carRepository;

    public CarService(IRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.getAll();
    }

    @Override
    public Car getById(long id) {
        return carRepository.getById(id);
    }

    @Override
    public void add(Car car) {
        carRepository.add(car);
    }

    @Override
    public void update(Car car) {
        carRepository.update(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);

    }

    @Override
    public double calculateCostTaxiPark() {
        log.info("IN calculateCostTaxiPark() : calculate was started");

        double sumCost = 0;

        for (Car eachCar : carRepository.getAll()
        ) {
            sumCost += eachCar.getCost();
        }

        return sumCost;
    }

    @Override
    public List<Car> findCarBySpeed(int minSpeed, int maxSpeed) {
        log.info("IN findCarBySpeed() :  find car was started");

        ArrayList<Car> list = (ArrayList<Car>) carRepository.getAll().stream()
                .filter(x -> x.getSpeed() > minSpeed)
                .filter(x -> x.getSpeed() < maxSpeed)
                .collect(Collectors.toList());

        if (list.size() == 0) {

            log.info("\" There are no cars with suitable characteristics for \" +\n" +
                    " \"the values you entered \"");

        }
        return list;
    }

    @Override
    public List<Car> sortByFuelConsumption() {
        log.info("IN sortByFuelConsumption() : sorting was started");

        return carRepository.getAll().stream()
                .sorted(Comparator.comparingDouble(Car::getFuelConsumption))
                .collect(Collectors.toList());

    }
}
