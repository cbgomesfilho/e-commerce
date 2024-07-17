package br.com.ecommerce.service.impl;

import br.com.ecommerce.exception.CategoryNotFoundException;
import br.com.ecommerce.model.Category;
import br.com.ecommerce.repository.CategoryRepository;
import br.com.ecommerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static java.lang.String.*;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findCategory(Integer id) {
        return categoryRepository.findById(id).
                orElseThrow(() -> new CategoryNotFoundException(format("Category not found to id %d", id)));
    }
}
