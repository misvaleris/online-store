package by.issoft.store.handlers.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PurchaseService {
    private final static Queue<Order> ORDERS = new ConcurrentLinkedQueue<>();

    private PurchaseService() {
        Runnable clearQueueTask = () -> {
            if (ORDERS.size() != 0) {
                log.info("\n---------Start clearing purchase queue---------");
                ORDERS.clear();
                log.info("\n----------End clearing purchase queue----------");
            } else {
                log.info("\n------------Purchase queue is empty------------");
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(clearQueueTask,
                120000, 120000, TimeUnit.MILLISECONDS);
    }

    public void purchaseOrder(Order order) {
        ORDERS.add(order);
    }
}
