package by.issoft.consoleApp;

public class TestSingleton {
    private static TestSingleton instance;

    private TestSingleton() {
        //
    }

    public synchronized static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }
}
