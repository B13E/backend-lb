
package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="ProductController", description = "Controller für Produkte")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET localhost:8080/product
    @GetMapping  // Maps to GET HTTP method
    @Operation(summary = "Erstellt eine Liste mit vorhandenen Produkte", operationId = "id", description = "Gibt eine Liste aller Produkte aus.")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/create")
    @Operation(summary = "Erstellt ein neues Produkt ", operationId = "create", description = "Erstellt ein neues Produkt in der Datenbank.")
    public Product createProduct(@RequestBody Product product) {

        return productService.create(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Ein erstelltes Produkt bearbeiten", operationId = "id", description = "Bei einer Fehleingabe oder einem Fehler im erstellten Produkt, kann das Produkt bearbeitet werden.")
    public Product updateProduct(@Parameter(description = "Das Produkt mit der angegebenen ID kann bearbeitet werden.")@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}") // 2mal {id} geht da es put oder delete ist
    @Operation(summary = "Löscht ein Produkt ", operationId = "id", description = "Löscht das Produkt mit der Eingegebenen ID und entfernt es aus der Datenbank.")
    public void deleteProduct(@Parameter(description = "Das Produkte mit der angegebenen ID wird aus der Datenbank entfernt.")@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping("/readBy{ID}")
    public Optional<Product> readProductById(@PathVariable int id) {

        return productService.findById(id);
    }
/*
    @PostMapping("/sortBy{ID}")
    public List<Product> sortProductsById(@PathVariable int id) {
        return productService.sortProductsById(id);
    }

    @PostMapping("/categorys/createBy{ID}")
    public Product createProductInCategory(@PathVariable int id, @RequestBody Product product) {
        return productService.createProductInCategory(id, product);
    }

    @GetMapping("/category/readBy{ID}")
    public Category readCategoryByProductId(@PathVariable int id) {
        return productService.findCategoryByProductId(id);
    }

    @PostMapping("/categorys/updateBy{ID}")
    public Category updateCategoryByProductId(@PathVariable int id, @RequestBody Category category) {
        return productService.updateCategoryByProductId(id, category);
    }

    @PostMapping("/category/deleteBy{ID}")
    public void deleteCategoryByProductId(@PathVariable int id) {
        productService.deleteCategoryByProductId(id);
    }

    @GetMapping("/categorys/list")
    public List<Category> listAllCategories() {
        return productService.findAllCategories();
    }

    @GetMapping("/category/productlist")
    public List<Product> listAllProductsInCategory() {
        return productService.findAllProductsInCategory();
    }

 */
}
