package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import com.example.demo.ressources.user.User;
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

    @Column(columnDefinition = "varchar(100)", nullable = false)
    public String sku; // Artikelnummer

    @Column(columnDefinition = "INT")
    public Integer active;

    @Column(columnDefinition = "varchar(500)", nullable = false)
    public String name;

    @Column(columnDefinition = "varchar(1000)", nullable = false)
    public String image;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    public String description;

    @Column(columnDefinition = "FLOAT", nullable = false)
    public Float price;

    @Column(columnDefinition = "INT", nullable = false)
    public Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
    /*
    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }

     */
