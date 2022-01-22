package by.issoft.store.handlers.order;

import by.issoft.domain.OrderInfo;
import by.issoft.domain.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PurchaseService {
    private final OrderRepository repository;

    private PurchaseService(OrderRepository repository) {
        this.repository = repository;
        Runnable clearQueueTask = () -> {
            if (repository.count() != 0) {
                log.info("\n---------Start clearing purchase queue---------");
                repository.deleteAll();
                log.info("\n----------End clearing purchase queue----------");
            } else {
                log.info("\n------------Purchase queue is empty------------");
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(clearQueueTask,
                120000, 120000, TimeUnit.MILLISECONDS);
    }

    public void purchaseOrder(OrderInfo orderInfo) {
        repository.save(orderInfo);
    }
}
