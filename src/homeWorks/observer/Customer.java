package homeWorks.observer;

import java.util.Objects;

public class Customer implements Observer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void update(Product product) {
        System.out.println(name + " received notification: New product " + product.getName() + ", price " + product.getPrice());
    }

    public String getName() {
        return name;
    }
}
