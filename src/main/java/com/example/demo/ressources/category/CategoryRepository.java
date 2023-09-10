package com.example.demo.ressources.category;

import com.example.demo.ressources.product.Product;
import com.example.demo.ressources.product.ProductRepository;
import com.example.demo.ressources.user.User;
import com.example.demo.ressources.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.name = :id")
    Category findCategoryById(Integer id);
}
