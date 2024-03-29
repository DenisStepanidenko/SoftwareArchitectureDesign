package homeWorks.adapter;

public class NewPaymentServiceImpl implements NewPaymentService{
    @Override
    public void makePayment(double totalAmount) {
        System.out.println("Processing payment of $" + totalAmount + " using the new payment service.");
    }
}
