package homeWorks.prototype;

public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car toyotaBlackCamry =  carFactory.createCar("sedan");
        toyotaBlackCamry.setColor("black");
        toyotaBlackCamry.setModel("Toyata Camry");
        toyotaBlackCamry.setEngineType("V6");

        System.out.println(toyotaBlackCamry);

        Car toyotaWhite = (Car) toyotaBlackCamry.copy();
        toyotaWhite.setColor("white");
        System.out.println(toyotaWhite);
    }
}
