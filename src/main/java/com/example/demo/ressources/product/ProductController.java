package com.example.demo.ressources.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="Product", description = "Controller für Produkte")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // List all products
    @GetMapping
    @Operation(summary = "Listet alle Produkte auf", operationId = "getAllProducts", description = "Gibt eine Liste aller Produkte aus.")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Liest ein Produkt durch ID", operationId = "readProductById", description = "Gibt das Produkt mit der spezifizierten ID zurück.")
    public Optional<Product> readProductById(@PathVariable @Parameter(description = "ID des zu lesenden Produkts.") int id) {
        return productService.findById(id);
    }

    // List all products based on a category ID
    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Listet alle Produkte basierend auf der Kategorie-ID", operationId = "getProductsByCategory", description = "Gibt eine Liste von Produkten basierend auf der Kategorie-ID zurück.")
    public List<Product> getProductsByCategory(@PathVariable @Parameter(description = "ID der Kategorie.") int categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    // Create a new product
    @PostMapping("/create")
    @Operation(summary = "Erstellt ein neues Produkt", operationId = "createProduct", description = "Erstellt ein neues Produkt in der Datenbank.")
    public Product createProduct(@RequestBody @Parameter(description = "Details des zu erstellenden Produkts.") Product product) {
        return productService.create(product);
    }

    // Update a product
    @PutMapping("/{id}")
    @Operation(summary = "Ein bestehendes Produkt bearbeiten", operationId = "updateProduct", description = "Bearbeitet das Produkt mit der angegebenen ID.")
    public Product updateProduct(@PathVariable @Parameter(description = "ID des zu bearbeitenden Produkts.") int id, @RequestBody @Parameter(description = "Neue Daten für das Produkt.") Product product) {
        return productService.update(id, product);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht ein Produkt", operationId = "deleteProduct", description = "Löscht das Produkt mit der angegebenen ID.")
    public void deleteProduct(@PathVariable @Parameter(description = "ID des zu löschenden Produkts.") Integer id) {
        productService.deleteById(id);
    }
}
