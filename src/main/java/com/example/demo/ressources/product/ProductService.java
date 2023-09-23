package com.example.demo.ressources.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service-Klasse für die Handhabung von Produkt-Operationen.
 * Diese Klasse enthält Methoden für CRUD-Operationen und Abfragen für Produkte.
 * Es ist mit @Service annotiert, um den Klassen-Scan von Spring zu ermöglichen,
 * sodass Spring dies als Service-Bean erkennt und behandelt.
 */
@Service
public class ProductService {

    // Repository für den Zugriff auf die Datenbank
    private final ProductRepository productRepository;

    /**
     * Konstruktor zur Injektion des ProductRepository.
     * @param productRepository Das Repository für den Zugriff auf Produkt-Entitäten.
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Findet alle Produkte in der Datenbank.
     * @return Eine Liste aller Produkte.
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Erstellt ein neues Produkt in der Datenbank.
     * @param product Das zu speichernde Produkt.
     * @return Das gespeicherte Produkt.
     */
    public Product create(Product product) {
        return productRepository.save(product);
    }

    /**
     * Aktualisiert ein bestehendes Produkt in der Datenbank.
     * @param id Die ID des zu aktualisierenden Produkts.
     * @param product Das Produkt mit den aktualisierten Daten.
     * @return Das aktualisierte Produkt oder null, wenn das Produkt nicht gefunden wurde.
     */
    public Product update(Integer id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    /**
     * Findet ein Produkt in der Datenbank anhand seiner ID.
     * @param id Die ID des zu findenden Produkts.
     * @return Das gefundene Produkt oder ein leeres Optional, wenn das Produkt nicht gefunden wurde.
     */
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    /**
     * Löscht ein Produkt aus der Datenbank anhand seiner ID.
     * @param id Die ID des zu löschenden Produkts.
     */
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    /**
     * Findet alle Produkte in der Datenbank, die zu einer bestimmten Kategorie gehören.
     * @param categoryId Die ID der Kategorie.
     * @return Eine Liste aller Produkte in der angegebenen Kategorie.
     */
    public List<Product> findByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
