package homeWorks.adapter;

public class Test {
    public static void main(String[] args) {
        PaymentService paymentService = new CurrentPaymentService();
        paymentService.processPayment(100);

        NewPaymentService newPaymentService = new NewPaymentServiceImpl();
        PaymentServiceAdapter paymentServiceAdapter = new PaymentServiceAdapter(newPaymentService);
        paymentServiceAdapter.processPayment(100);
    }
}
