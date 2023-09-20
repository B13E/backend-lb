package com.example.demo.ressources.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="Category", description = "Controller für Kategorien")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Listet alle Kategorien auf.", operationId = "listAllCategories", description = "Sucht nach allen Einträgen in Kategorien und erstellt eine Liste mit den vorhandenen Kategorien aus der Datenbank.")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Findet eine Kategorie durch ihre ID.", operationId = "findCategoryById", description = "Ruft eine Kategorie durch die angegebene ID ab.")
    public Optional<Category> findById(@PathVariable @Parameter(description = "ID der Kategorie, die abgerufen werden soll.") Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Neue Kategorie erstellen", operationId = "createCategory", description = "Erstellt eine neue Kategorie in der Datenbank.")
    public Category createCategory(@RequestBody @Parameter(description = "Details der zu erstellenden Kategorie.") Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aktualisiert eine Kategorie durch ihre ID.", operationId = "updateCategoryById", description = "Aktualisiert die Details einer Kategorie, die der angegebenen ID entspricht.")
    public Category updateCategory(@PathVariable @Parameter(description = "ID der Kategorie, die aktualisiert werden soll.") int id,
                                   @RequestBody @Parameter(description = "Neue Daten für die Kategorie.") Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht eine Kategorie durch ihre ID.", operationId = "deleteCategoryById", description = "Löscht die Kategorie, die der angegebenen ID entspricht.")
    public void deleteCategory(@PathVariable @Parameter(description = "ID der Kategorie, die gelöscht werden soll.") Integer id) {
        categoryService.deleteById(id);
    }
}
