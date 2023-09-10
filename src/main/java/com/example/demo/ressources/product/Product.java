package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(columnDefinition = "varchar(100)")
    public String sku;

    @Column(columnDefinition = "varchar(500)", nullable = false)
    public String name;

    @Column(columnDefinition = "varchar(1000)", nullable = false)
    public String image;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    public String description;

    @Column(columnDefinition = "FLOAT")
    public Float price;

    @Column(columnDefinition = "INT", nullable = false)
    public Integer stock;

    @ManyToOne()
    public Category category;

}
    /*
    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }

     */


/*
package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // ... existing fields

    @ManyToOne
    private Category category;

    // Getters and Setters
}

 */