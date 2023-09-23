package com.example.demo.ressources.category;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * CategoryService ist eine Service-Klasse, die Operationen zur Interaktion
 * mit Kategorien kapselt, einschließlich der Kommunikation mit der Datenbank
 * über das CategoryRepository.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Konstruktor zum Initialisieren des CategoryRepository.
     * @param categoryRepository Das Repository, das zur Interaktion mit der Datenbank verwendet wird.
     */
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Gibt eine Liste aller Kategorien zurück.
     * @return Liste von Kategorien.
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Erstellt eine neue Kategorie.
     * @param category Die zu speichernde Kategorie.
     * @return Die gespeicherte Kategorie.
     */
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Aktualisiert die Kategorie mit der angegebenen ID.
     * @param id Die ID der zu aktualisierenden Kategorie.
     * @param category Die Kategorie mit den aktualisierten Daten.
     * @return Die aktualisierte Kategorie oder null, wenn keine Kategorie mit der angegebenen ID gefunden wurde.
     */
    public Category update(Integer id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    /**
     * Sucht nach einer Kategorie mit der angegebenen ID.
     * @param id Die ID der gesuchten Kategorie.
     * @return Ein Optional, das die gefundenen Kategorie oder leer ist, wenn keine Kategorie gefunden wurde.
     */
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    /**
     * Löscht die Kategorie mit der angegebenen ID.
     * @param id Die ID der zu löschenden Kategorie.
     */
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
