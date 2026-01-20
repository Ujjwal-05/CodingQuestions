package SystemDesign.Patterns.Strategy;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(int amount) {
        strategy.pay(amount);
    }
}

public class Strategy {
    public static void main(String[] args) {

        UpiPayment upiPayment = new UpiPayment();
        PaymentService payment1 = new PaymentService(upiPayment);
        payment1.makePayment(500);

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PaymentService payment2 = new PaymentService(creditCardPayment);
        payment2.makePayment(1000);
    }
}

