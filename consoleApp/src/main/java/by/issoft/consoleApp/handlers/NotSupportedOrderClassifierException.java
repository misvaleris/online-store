package by.issoft.consoleApp.handlers;

public class NotSupportedOrderClassifierException extends RuntimeException {
    public NotSupportedOrderClassifierException() {
        super("No support for sort classifiers");
    }

}
