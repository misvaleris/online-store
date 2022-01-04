package by.issoft.store.handlers.product;

public class NotSupportedOrderClassifierException extends RuntimeException {
    public NotSupportedOrderClassifierException() {
        super("No support for sort classifiers");
    }
}
