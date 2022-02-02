package by.issoft.consoleApp;

import by.issoft.domain.Store;
import by.issoft.domain.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("stores/")
public class StoreController {
    private final StoreRepository storeRepository;

    @GetMapping("{storeId}")
    public String getById(@PathVariable(name = "storeId") Long storeId) {
        return storeRepository.findById(storeId)
                .map(Store::toString)
                .orElseThrow(EntityNotFoundException::new);
    }
}
