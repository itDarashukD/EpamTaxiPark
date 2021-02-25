package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor

public class Car extends Model {

    private String carModel;
    private double cost;
    private double fuelConsumption;
    private int speed;

}
