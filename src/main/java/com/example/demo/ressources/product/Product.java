package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(100)")
    private String sku;

    @Column(columnDefinition = "varchar(500)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(1000)", nullable = false)
    private String image;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "FLOAT")
    private Float price;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer stock;

    @ManyToOne()
    private Category category;

    /*
    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }

     */
}
