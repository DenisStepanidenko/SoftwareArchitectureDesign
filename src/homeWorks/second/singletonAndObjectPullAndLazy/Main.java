package homeWorks.second.singletonAndObjectPullAndLazy;

public class Main {
    public static void main(String[] args) {
        CarPool carPool = CarPool.getInstance();
        Car rentedCar1 = carPool.rentCar("Nissan", "X-Trail", "Silver");
        Car rentedCar2 = carPool.rentCar("Volkswagen", "Polo", "Yellow");
        Car rentedCar3 = carPool.rentCar("UAZ", "Hunter", "Green");

        carPool.finishRental(rentedCar1);
        carPool.finishRental(new Car("afa", "sa", "sf"));
    }

}
