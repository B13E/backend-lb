package com.example.demo.ressources.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="CategoryController", description = "Controller für Kategorien")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Listet alle Kategorien auf.", operationId = "id", description = "Sucht nach allen Einträgen in Kategorien und erstellt eine Liste mit den vorhandenen Kategorien aus der Datenbank.")
    public List<Category> getAllCategories() {

        return categoryService.findAll();
    }

    @PostMapping("/create")
    @Operation(summary = "Löscht ein Produkt ", operationId = "id", description = "Erstellt eine neue Kategorie in der Datenbank.")
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
