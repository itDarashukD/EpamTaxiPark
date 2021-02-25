package api.repository;

import model.Car;

import java.util.List;

public interface IModelRepository<T> {


    void add(T t);

    List<Car> getAll();

    Car getById(long id);

    void update(T t);

    void delete(T t);


}
