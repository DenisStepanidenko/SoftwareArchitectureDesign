package homeWorks.second.singletonAndObjectPullAndLazy;

import java.util.ArrayList;
import java.util.List;

// ==
// +=
// ++
// +
// =
public class CarPool {
    private static CarPool instance;

    List<Car> availableCars;
    List<Car> rentedCars;

    private CarPool() {
        rentedCars = new ArrayList<>();
        availableCars = loadCars();
    }

    public static CarPool getInstance() {
        if (instance == null) {
            instance = new CarPool();
        }
        return instance;
    }

    private List<Car> loadCars() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", "Accord", "White"));
        cars.add(new Car("Skoda", "Octavia", "Green"));
        cars.add(new Car("Nissan", "X-Trail", "Silver"));
        cars.add(new Car("Hyundai", "Solaris", "Yellow"));
        cars.add(new Car("Toyota", "Camry", "Snowy-white"));
        cars.add(new Car("Mazda", "6", "Red"));
        cars.add(new Car("UAZ", "Hunter", "Green"));
        cars.add(new Car("Volkswagen", "Polo", "Black"));
        cars.add(new Car("Renault", "Duster", "Orange"));
        cars.add(new Car("Lada", "Granta", "Carnelian"));

        return cars;
    }

    public Car rentCar(String brand, String model, String color) {

        Car neededCar = new Car(brand, model, color);

        for (var car : availableCars) {
            if (car.compareTo(neededCar) == 0) {
                rentedCars.add(car);
                availableCars.remove(car);
                System.out.printf("The car (Brand: %s, Model: %s, Color: %s) rental has started.\n",
                        neededCar.brand, neededCar.model, neededCar.color);
                return car;
            }
        }
        System.out.printf("We are sorry. There is no car with such parameters (Brand: %s, Model: %s, " +
                "Color: %s) at the moment.\n", neededCar.brand, neededCar.model, neededCar.color);
        return null;
    }

    public void finishRental(Car rentedCar) {
        if (rentedCars.contains(rentedCar)) {
            availableCars.add(rentedCar);
            rentedCars.remove(rentedCar);

            System.out.printf("The car (Brand: %s, Model: %s, Color: %s) rental is finished.\n",
                    rentedCar.brand, rentedCar.model, rentedCar.color);
        } else  {
            System.out.printf("We are sorry. The car (Brand: %s, Model: %s, Color: %s) has not been rented.\n",
                    rentedCar.brand, rentedCar.model, rentedCar.color);
        }

    }
}
