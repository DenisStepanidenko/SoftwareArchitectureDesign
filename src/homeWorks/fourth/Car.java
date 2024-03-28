package homeWorks.fourth;

// ==
// +=
// ++
// +
// =
abstract class Car implements Copyable{
    private String model;
    private String color;
    private String engineType;

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngineType() {
        return engineType;
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

    public Car() {

    }
    public Car(Car target) {
        if (target != null) {
            this.model = target.getModel();
            this.color = target.getColor();
            this.engineType = target.getEngineType();
        }
    }
    public void printDetails() {

    }

    public abstract Car copy();

}
