package com.example.demo.ressources.user;
import com.example.demo.ressources.category.Category;
import com.example.demo.ressources.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Diese Klasse repräsentiert einen Benutzer in der Anwendung.
 */
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(255)")
    private String username;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String passwort;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date birthday;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String street;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer plz;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String country;

    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private Boolean admin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    /**
     * Gibt die Rollen des Benutzers zurück.
     * In diesem Fall werden immer "ROLE_ADMIN" zurückgegeben, da es sich um eine Hartcodierung handelt.
     * In einer echten Anwendung würden die Rollen dynamisch festgelegt.
     *
     * @return Die Liste der Benutzerrollen.
     */
    public List<String> getRoles() {
        List<String> hardcodedRoles = new ArrayList<>();
        hardcodedRoles.add("ROLE_ADMIN");
        return hardcodedRoles;
    }

    /**
     * Diese Methode kann verwendet werden, um einen Benutzer zum Administrator zu befördern.
     * Sie setzt das Admin-Flag auf "true".
     */
    public void upgradeToAdmin() {
        this.admin = true;
    }

    /**
     * Diese Methode kann verwendet werden, um zu überprüfen, ob ein Benutzer ein Administrator ist.
     *
     * @return true, wenn der Benutzer ein Administrator ist, sonst false.
     */
    public boolean isAdmin() {
        return this.admin;
    }
}


