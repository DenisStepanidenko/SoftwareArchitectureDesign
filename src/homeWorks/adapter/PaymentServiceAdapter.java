package homeWorks.adapter;

public class PaymentServiceAdapter implements PaymentService {
    private final NewPaymentService newPaymentService;

    public PaymentServiceAdapter(NewPaymentService newPaymentService) {
        this.newPaymentService = newPaymentService;
    }

    @Override
    public void processPayment(double amount) {
        newPaymentService.makePayment(amount);
    }
}
