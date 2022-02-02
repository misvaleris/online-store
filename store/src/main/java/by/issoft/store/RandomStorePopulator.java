package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RandomStorePopulator {
    private final CategoryRepository categoryRepository;

    public List<Category> generateCategories() {
        return categoryRepository.findAll();
    }
}
