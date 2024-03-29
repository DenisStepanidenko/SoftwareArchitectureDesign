package homeWorks.adapter;

public class CurrentPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " using the current payment service.");
    }
}
