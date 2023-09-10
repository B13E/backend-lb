package com.example.demo.ressources.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        //    System.out.println("uhu");
        return productRepository.save(product);
    }

    public Product update(int id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());

            return productRepository.save(existingProduct);
        }
        return null;
    }

    public Optional<Product> findById(int id) {

        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
/*
    public List<Product> sortProductsById(int id) {
        productRepository.sortProductsById(id);
    }

    public Product createProductInCategory(int categoryId, Product product) {
        // Dies erfordert zusätzliche Logik und Abhängigkeiten, z.B. ein CategoryRepository
        // Ich gebe ein Beispiel, das wahrscheinlich nicht Ihrem genauen Modell entspricht:
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            product.setCategory(category);
            return productRepository.save(product);
        }
        return null;
    }

    public Category findCategoryByProductId(int productId) {
        productRepository.findCategoryByProductId(productId);
    }

    public Category updateCategoryByProductId(int productId, Category category) {
        productRepository.updateCategoryByProductId(productId);
    }

    public void deleteCategoryByProductId(int productId) {
        productRepository.deleteCategoryByProductId(productId);
    }

    public List<Category> findAllCategories() {
        productRepository.findAllCategories();
    }

    public List<Product> findAllProductsInCategory() {
        productRepository.findAllProductsInCategory();
    }

 */
}

/*
package com.example.demo.ressources.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
    //    System.out.println("uhu");
        return productRepository.save(product);
    }

    public Product update(int id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());

            return productRepository.save(existingProduct);
        }
        return null;
    }

    public Optional<Product> findById(int id) {

        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}



 */