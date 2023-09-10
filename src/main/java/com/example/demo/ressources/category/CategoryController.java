package com.example.demo.ressources.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {

        return categoryService.findAll();
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {

        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {

        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}") // 2mal {id} geht da es put und delete ist
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteById(id);
    }

    @GetMapping("/category/list")
    public List<Category> listCategories() {
        return categoryService.findAll();
    }
}
