package by.issoft.consoleApp;

import by.issoft.domain.StoreRepository;
import by.issoft.store.handlers.product.sort.GetSortByPriceRateNameProductCommand;
import by.issoft.store.handlers.product.top.GetTop5ByPriceProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("stores/{storeId}/products")
public class ProductController {
    private final GetSortByPriceRateNameProductCommand sortByPriceRateNameProductCommand;
    private final GetTop5ByPriceProductCommand top5ByPriceProductCommand;
    private final StoreRepository storeRepository;

    @GetMapping("/sort-by-price-rate-name")
    public String getSortByPriceRateNameProduct(@PathVariable(name = "storeId") Long storeId) {
        return storeRepository.findById(storeId)
                .map(sortByPriceRateNameProductCommand::execute)
                .orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/top-5-by-price")
    public String getTop5ByPrice(@PathVariable(name = "storeId") Long storeId) {
        return storeRepository.findById(storeId)
                .map(top5ByPriceProductCommand::execute)
                .orElseThrow(EntityNotFoundException::new);
    }
}
