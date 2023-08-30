package com.example.demo.ressources.user;

import com.example.demo.ressources.category.Category;
import com.example.demo.ressources.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Category findUserRepositoriesBy(String email);
}


