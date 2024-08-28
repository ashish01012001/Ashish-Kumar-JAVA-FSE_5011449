package Week1.Design_Patterns_And_Principles;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalPayment {
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class StripePayment {
    public void pay(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }
}

class SquarePayment {
    public void processSquarePayment(double amount) {
        System.out.println("Processing Square payment of $" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void processPayment(double amount) {
        payPalPayment.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) {
        stripePayment.pay(amount);
    }
}

class SquareAdapter implements PaymentProcessor {
    private SquarePayment squarePayment;

    public SquareAdapter(SquarePayment squarePayment) {
        this.squarePayment = squarePayment;
    }

    @Override
    public void processPayment(double amount) {
        squarePayment.processSquarePayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        // PayPal payment
        PayPalPayment payPalPayment = new PayPalPayment();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalPayment);
        payPalAdapter.processPayment(100.0);

        // Stripe payment
        StripePayment stripePayment = new StripePayment();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripePayment);
        stripeAdapter.processPayment(200.0);

        // Square payment
        SquarePayment squarePayment = new SquarePayment();
        PaymentProcessor squareAdapter = new SquareAdapter(squarePayment);
        squareAdapter.processPayment(300.0);
    }
}
