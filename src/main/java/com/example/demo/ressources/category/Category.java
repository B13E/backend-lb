package com.example.demo.ressources.category;

import com.example.demo.ressources.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Die Category Klasse ist die Entität, die in der Datenbank gespeichert wird.
 * Getter und Setter Methoden werden durch Lombok generiert.
 */
@Entity
@Getter
@Setter
public class Category {

    /**
     * Die ID der Kategorie. Sie ist der Primärschlüssel in der Datenbank.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Der Status der Kategorie.
     */
    @Column(columnDefinition = "TINYINT")
    private Integer active;

    /**
     * Der Name der Kategorie, er darf nicht leer sein.
     */
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;

    /**
     * Eine Liste von Produkten, die zu dieser Kategorie gehören.
     * Die Beziehung zwischen Kategorien und Produkten ist OneToMany,
     * d.h. eine Kategorie kann mehrere Produkte enthalten.
     */
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;
}
