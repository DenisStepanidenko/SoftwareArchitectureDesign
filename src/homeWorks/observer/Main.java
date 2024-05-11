package homeWorks.observer;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        Input input = new Input();


        while (true) {
            int choice = input.getChoice();
            String name;
            switch (choice) {
                case 1:
                    name = input.getName();
                    notificationService.addObserver(new Customer(name));
                    break;
                case 2:
                    name = input.getName();
                    notificationService.removeObserver(new Customer(name));
                    break;
                case 3:
                    String nameOfProduct = input.getNameOfProduct();
                    double price = input.getPrice();
                    notificationService.addNewProduct(new Product(nameOfProduct, price));
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
