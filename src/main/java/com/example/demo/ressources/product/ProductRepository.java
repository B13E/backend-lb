package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

        @Repository
        public interface ProductRepository extends JpaRepository<Product, Integer> {
            @Query("SELECT p FROM Product p WHERE p.name = :name")
            Category findProductRepositoriesBy(String name);
        }


/*
package com.example.demo.ressources.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByName(String name);
}

 */