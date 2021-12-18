package by.issoft.consoleApp.handlers.product;

public class NotSupportedOrderClassifierException extends RuntimeException {
    public NotSupportedOrderClassifierException() {
        super("No support for sort classifiers");
    }
}
