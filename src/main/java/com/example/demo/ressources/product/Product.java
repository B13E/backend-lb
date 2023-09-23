package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import com.example.demo.ressources.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Repräsentiert ein Produkt im System.
 * Jedes Produkt hat verschiedene Attribute und kann einer Kategorie und einem Benutzer zugeordnet sein.
 */
@Entity  // Gibt an, dass diese Klasse eine Entität ist, die in der Datenbank persistiert wird.
@Getter  // Lombok-Annotation zum Generieren von Getter-Methoden für alle Felder.
@Setter  // Lombok-Annotation zum Generieren von Setter-Methoden für alle Felder.
public class Product {

    @Id  // Markiert dieses Feld als Primärschlüssel.
    @GeneratedValue(strategy = GenerationType.AUTO)  // Gibt an das die ID automatisch erstellt wird.
    private Integer id;  // Eindeutige Identifikationsnummer des Produkts.

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String sku;  // Stock Keeping Unit (Artikelnummer) des Produkts.

    @Column(columnDefinition = "INT")
    private Integer active;  // Status des Produkts: aktiv (1) oder inaktiv (0).

    @Column(columnDefinition = "varchar(500)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(1000)", nullable = false)
    private String image;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "FLOAT", nullable = false)
    private Float price;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)  // Viele-zu-eins-Beziehung zu Category.
    @JoinColumn(name = "category_id")  // Fremdschlüssel-Definition.
    private Category category;  // Kategorie, zu der das Produkt gehört.

    @ManyToOne(fetch = FetchType.LAZY)  // Viele-zu-eins-Beziehung zu User.
    @JoinColumn(name = "user_id")  // Fremdschlüssel-Definition.
    private User user;  // Benutzer, dem dieses Produkt zugeordnet ist.
}
