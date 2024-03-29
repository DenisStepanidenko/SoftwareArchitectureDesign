package homeWorks.prototype;

public class Car implements Copyable {
    private String model;
    private String color;
    private String engineType;

    public Car(String model, String color, String engineType) {
        this.model = model;
        this.color = color;
        this.engineType = engineType;
    }

    public Car() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public Object copy() {
        return new Car(model, color, engineType);
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +
                '}';
    }
}
