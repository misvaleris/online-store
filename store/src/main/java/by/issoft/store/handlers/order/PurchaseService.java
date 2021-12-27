package by.issoft.store.handlers.order;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PurchaseService {
    private static PurchaseService INSTANCE;
    private final static Queue<Order> ORDERS = new ConcurrentLinkedQueue<>();

    private PurchaseService() {
        Runnable clearQueueTask = () -> {
            while (true) {
                if (ORDERS.size() != 0) {
                    System.out.println("\n---------Start clearing purchase queue---------");
                    ORDERS.clear();
                    System.out.println("\n----------End clearing purchase queue----------");
                }
                else{
                    System.out.println("\n------------Purchase queue is empty------------");
                }
                try {
                    Thread.sleep(120000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        CompletableFuture.runAsync(clearQueueTask);
    }

    public static synchronized PurchaseService getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new PurchaseService();
        }
        return INSTANCE;
    }

    public void purchaseOrder(Order order) {
        ORDERS.add(order);
    }
}
