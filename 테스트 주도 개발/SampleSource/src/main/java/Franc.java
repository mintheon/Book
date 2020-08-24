public class Franc extends Money{
    private String currency;

    Franc(int amount, String currency) {
        super(amount, currency);
    }

    String currency() {
        return currency;
    }

    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }
}
