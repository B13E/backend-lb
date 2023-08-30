package com.example.demo.ressources.category;

import com.example.demo.ressources.product.Product;
import jakarta.persistence.*;

import java.util.Collection;

import static java.sql.JDBCType.TINYINT;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

@Column(columnDefinition = "TINYINT")
    private Integer active;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String name;


}
