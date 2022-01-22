package by.issoft.consoleApp;

import by.issoft.domain.OrderInfo;
import by.issoft.domain.OrderRepository;
import by.issoft.domain.Product;
import by.issoft.domain.ProductRepository;
import by.issoft.store.handlers.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("orders/")
public class OrderController {
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping
    public List<OrderInfo> getAll() {
        return orderRepository.findAll();
    }

    @PostMapping("create")
    public void createOrder(@RequestBody OrderCreateInfo info) {
        Set<Product> productList = productRepository.findAllByIdIn(info.getProductIds());
        orderService.createOrder(productList);
    }
}
