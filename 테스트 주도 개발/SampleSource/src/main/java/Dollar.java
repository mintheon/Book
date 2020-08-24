public class Dollar extends Money{
    private String currency;

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier) {
        return new Dollar(amount * multiplier, currency);
    }

    String currency() {
        return currency;
    }
}
