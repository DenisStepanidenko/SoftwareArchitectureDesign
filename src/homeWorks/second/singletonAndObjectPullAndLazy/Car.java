package homeWorks.second.singletonAndObjectPullAndLazy;

// ==
// +=
// ++
// +
// =
public class Car implements Comparable<Car> {
    String brand;
    String model;
    String color;

    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public int compareTo(Car car) {
        if (brand.equals(car.brand) && model.equals(car.model) && color.equals(car.color)) {
            return 0;
        }
        return -1;
    }
}
