package repository;

import api.repository.IRepository;
import model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository implements IRepository {

    private final Map<Long, Car> carMap = new HashMap<>();

    @Override
    public void add(Car car) {
        carMap.put(car.getId(), car);
    }


    @Override
    public List<Car> getAll() {
        return new ArrayList<>(carMap.values());

    }

    @Override
    public Car getById(long id) {
        return carMap.get(id);
    }

    @Override
    public void update(Car car) {

        carMap.put(car.getId(), car);

    }

    @Override
    public void delete(Car car) {

        carMap.remove(car.getId());

    }
}
