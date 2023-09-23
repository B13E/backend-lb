package com.example.demo.ressources.category;

import com.example.demo.ressources.product.Product;
import com.example.demo.ressources.product.ProductRepository;
import com.example.demo.ressources.user.User;
import com.example.demo.ressources.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Das CategoryRepository Interface stellt Methoden zur Verfügung, um auf
 * Kategorien in der Datenbank zuzugreifen. Es erweitert JpaRepository, um
 * Standardmethoden wie save(), findById() usw. zu erben.
 * Es ist mit dem @Repository-Annotation markiert, um Spring mitzuteilen,
 * dass es sich um ein Bean handelt, das Datenzugriffsfunktionalität kapselt.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Diese Methode findet eine Kategorie in der Datenbank anhand ihres Namens.
     * @param name Der Name der gesuchten Kategorie.
     * @return Das Category-Objekt, das dem Namen entspricht, oder null, wenn keine gefunden wird.
     */
    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Category findCategoryByName(String name);
}
