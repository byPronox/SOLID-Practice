package dip;

import dip.implementations.CreditCardPayment;
import dip.implementations.CryptoPayment;
import dip.implementations.PayPalPayment;
import dip.services.PaymentProcessor;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- TEST DIP ---");

        PaymentProcessor creditCardProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardProcessor.makePayment(150.0);

        PaymentProcessor payPalProcessor = new PaymentProcessor(new PayPalPayment());
        payPalProcessor.makePayment(200.0);

        PaymentProcessor cryptoProcessor = new PaymentProcessor(new CryptoPayment());
        cryptoProcessor.makePayment(300.0);
    }
}