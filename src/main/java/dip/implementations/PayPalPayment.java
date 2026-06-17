package dip.implementations;

import dip.interfaces.PaymentMethod;

public class PayPalPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}