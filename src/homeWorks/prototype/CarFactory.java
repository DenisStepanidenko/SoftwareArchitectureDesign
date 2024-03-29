package homeWorks.prototype;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private Car car = new Car();


    public Car createCar(String type) {
        return (Car) car.copy();
    }
}
