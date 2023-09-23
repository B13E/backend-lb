package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository-Interface für den Zugriff auf Produkt-Entitäten in der Datenbank.
 * Dieses Interface erweitert JpaRepository, um CRUD-Operationen für Produkt-Entitäten bereitzustellen.
 * Es ist mit @Repository annotiert, um Spring mitzuteilen, dass es ein Bean ist und
 * die automatische Konfiguration für das Repository ermöglicht.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Findet ein Produkt anhand seines Namens.
     * @param name Der Name des Produkts, das gefunden werden soll.
     * @return Das gefundene Produkt oder null, falls kein Produkt mit dem angegebenen Namen existiert.
     */
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findProductByName(String name);

    /**
     * Findet eine Liste von Produkten anhand ihrer Kategorie-ID.
     * @param categoryId Die ID der Kategorie, zu der die Produkte gehören sollen.
     * @return Eine Liste von Produkten, die zur angegebenen Kategorie-ID gehören.
     */
    List<Product> findByCategoryId(Integer categoryId);
}
