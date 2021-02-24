package api.service;

import model.Car;

import java.util.List;

public interface ICarService extends IModelService<Car> {

    double calculateCostTaxiPark();

    List<Car> findCarBySpeed(int minSpeed,int maxSpeed);

    List<Car> sortByFuelConsumption();
}
