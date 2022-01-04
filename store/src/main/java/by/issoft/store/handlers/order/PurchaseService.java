package by.issoft.store.handlers.order;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PurchaseService {
    private static PurchaseService INSTANCE;
    private final static Queue<Order> ORDERS = new ConcurrentLinkedQueue<>();

    private PurchaseService() {
        Runnable clearQueueTask = () -> {
            if (ORDERS.size() != 0) {
                System.out.println("\n---------Start clearing purchase queue---------");
                ORDERS.clear();
                System.out.println("\n----------End clearing purchase queue----------");
            } else {
                System.out.println("\n------------Purchase queue is empty------------");
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(clearQueueTask,
                120000, 120000, TimeUnit.MILLISECONDS);
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
