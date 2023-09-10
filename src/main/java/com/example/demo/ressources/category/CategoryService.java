package com.example.demo.ressources.category;

import com.example.demo.ressources.product.Product;
import com.example.demo.ressources.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(int id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();
            existingCategory.setName(category.getName());

            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}