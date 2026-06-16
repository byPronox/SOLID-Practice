package dip;
import dip.implementations.CreditCardPayment;
import dip.services.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TEST DIP ---");
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
        processor.makePayment(150.0);
    }
}