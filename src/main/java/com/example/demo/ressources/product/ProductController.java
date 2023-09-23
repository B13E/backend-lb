package com.example.demo.ressources.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Der ProductController ist verantwortlich für die Handhabung eingehender HTTP-Anfragen
 * bezüglich der Produkte. Die Klasse ist mit @RestController annotiert, wodurch sie als
 * Controller in einer Spring-Webanwendung registriert wird.
 */
@RestController
@Tag(name = "Product", description = "Controller für Produkte")
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Handler-Methode für GET-Anfragen zum Abrufen aller Produkte.
     * @return Liste aller Produkte.
     */
    @GetMapping
    @Operation(
            summary = "Listet alle Produkte auf",
            operationId = "getAllProducts",
            description = "Gibt eine Liste aller Produkte aus."
    )
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    /**
     * Handler-Methode für GET-Anfragen zum Abrufen eines Produkts anhand seiner ID.
     * @param id Die ID des Produkts.
     * @return Das Produkt mit der angegebenen ID.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Liest ein Produkt durch ID",
            operationId = "readProductById",
            description = "Gibt das Produkt mit der spezifizierten ID zurück."
    )
    public Optional<Product> readProductById(@PathVariable @Parameter(description = "ID des zu lesenden Produkts.") Integer id) {
        return productService.findById(id);
    }

    /**
     * Handler-Methode für GET-Anfragen zum Abrufen aller Produkte einer bestimmten Kategorie.
     * @param categoryId Die ID der Kategorie.
     * @return Liste der Produkte in der angegebenen Kategorie.
     */
    @GetMapping("/category/{categoryId}")
    @Operation(
            summary = "Listet alle Produkte basierend auf der Kategorie-ID",
            operationId = "getProductsByCategory",
            description = "Gibt eine Liste von Produkten basierend auf der Kategorie-ID zurück."
    )
    public List<Product> getProductsByCategory(@PathVariable @Parameter(description = "ID der Kategorie.") Integer categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    /**
     * Handler-Methode für POST-Anfragen zum Erstellen eines neuen Produkts.
     * @param product Das zu erstellende Produkt.
     * @return Das erstellte Produkt.
     */
    @PostMapping("/create")
    @Operation(
            summary = "Erstellt ein neues Produkt",
            operationId = "createProduct",
            description = "Erstellt ein neues Produkt in der Datenbank."
    )
    public Product createProduct(@RequestBody @Parameter(description = "Details des zu erstellenden Produkts.") Product product) {
        return productService.create(product);
    }

    /**
     * Handler-Methode für PUT-Anfragen zum Aktualisieren eines bestehenden Produkts.
     * @param id Die ID des zu aktualisierenden Produkts.
     * @param product Die neuen Daten des Produkts.
     * @return Das aktualisierte Produkt.
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Ein bestehendes Produkt bearbeiten",
            operationId = "updateProduct",
            description = "Bearbeitet das Produkt mit der angegebenen ID."
    )
    public Product updateProduct(@PathVariable @Parameter(description = "ID des zu bearbeitenden Produkts.") Integer id,
                                 @RequestBody @Parameter(description = "Neue Daten für das Produkt.") Product product) {
        return productService.update(id, product);
    }

    /**
     * Handler-Methode für DELETE-Anfragen zum Löschen eines Produkts.
     * @param id Die ID des zu löschenden Produkts.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Löscht ein Produkt",
            operationId = "deleteProduct",
            description = "Löscht das Produkt mit der angegebenen ID."
    )
    public void deleteProduct(@PathVariable @Parameter(description = "ID des zu löschenden Produkts.") Integer id) {
        productService.deleteById(id);
    }
}
