package homeWorks.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Observed{

    private List<Observer> observers = new ArrayList<>();


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        Customer customer = (Customer) observer;
        if(observers.remove(observer)){
            System.out.println("Клиент с именем " + customer.getName() + " успешно удалён");
        }
        else{
            System.out.println("Не удалось найти клиента с таким именем");
        }
    }

    @Override
    public void notifyObservers(Product product) {
        for (Observer observer : observers) {
            observer.update(product);
        }
    }

    public void addNewProduct(Product product) {
        System.out.println("New product added: " + product.getName());
        notifyObservers(product);
    }
}
