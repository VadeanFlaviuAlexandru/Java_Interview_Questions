package CodingProblems.DesignPatterns.BehavioralPatterns;

import lombok.Data;
import lombok.Setter;

public class TheStrategyPattern {
    // strategies are completely independent and unaware of each other
    // strategies are about having different implementations that accomplish the same thing

    public interface PaymentStrategy {

        void collectPaymentDetails();

        boolean validatePaymentDetails();

        void pay(int amount);

    }

    public static class PaymentByPayPal implements PaymentStrategy {

        private String email;
        private String password;

        @Override
        public void collectPaymentDetails() {
            // Pop-up to collect PayPal mail and password...
            email = "PayPal Mail";
            password = "PayPal Password";
            System.out.println("Collecting PayPal Account Details...");
        }

        @Override
        public boolean validatePaymentDetails() {
            // Validate account...
            System.out.printf("Validating PayPal Info: %s | %s%n", email, password);
            return true;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paying " + amount + " using PayPal");
        }

    }

    // -----------
    @Data
    public static class CreditCard {

        private int amount = 1_000;
        private final String number;
        private final String date;
        private final String cvv;

    }

    public static class PaymentByCreditCard implements PaymentStrategy {


        private CreditCard card;

        @Override
        public void collectPaymentDetails() {
            // Pop-up to collect card details...
            card = new CreditCard("cardNumber", "expiryDate", "cvv");
            System.out.println("Collecting Card Details...");
        }

        @Override
        public boolean validatePaymentDetails() {
            // Validate credit card...
            System.out.println("Validating Card Info: " + card);
            return true;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paying " + amount + " using Credit Card");
            card.setAmount(card.getAmount() - amount);
        }

    }
    // -----------


    @Setter
    public static class PaymentService {

        private int cost;
        private boolean includeDelivery = true;

        private PaymentStrategy strategy;

        public void processOrder(int cost) {
            this.cost = cost;
            strategy.collectPaymentDetails();
            if (strategy.validatePaymentDetails()) {
                strategy.pay(getTotal());
            }
        }

        private int getTotal() {
            return includeDelivery ? cost + 10 : cost;
        }

    }


    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        // The strategy can now be easily picked at runtime

        paymentService.setStrategy(new PaymentByCreditCard());
        paymentService.processOrder(100);

        System.out.println("==========================================");

        paymentService.setStrategy(new PaymentByPayPal());
        paymentService.processOrder(100);

    }
}
