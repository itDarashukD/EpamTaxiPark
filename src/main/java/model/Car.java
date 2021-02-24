package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class Car extends Model {

    private String carModel;
    private double cost;
    private double fuelConsumption;
    private int speed;

}
