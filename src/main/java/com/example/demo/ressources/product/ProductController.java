
package com.example.demo.ressources.product;

import com.example.demo.ressources.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // Indicates that this is a REST controller
@RequestMapping("/product")  // Sets the base URL path
public class ProductController {

    @Autowired
    private ProductService productService;  // Made private for encapsulation

    // GET localhost:8080/product
    @GetMapping  // Maps to GET HTTP method
    public List<Product> getAllProducts() {  // Renamed for clarity
        return productService.findAll();  // Assuming the method in ProductService is called 'findAll'
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {

        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}") // 2mal {id} geht da es put oder delete ist
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping("/readBy{ID}")
    public Optional<Product> readProductById(@PathVariable int id) {

        return productService.findById(id);
    }
/*
    @PostMapping("/sortBy{ID}")
    public List<Product> sortProductsById(@PathVariable int id) {
        return productService.sortProductsById(id);
    }

    @PostMapping("/categorys/createBy{ID}")
    public Product createProductInCategory(@PathVariable int id, @RequestBody Product product) {
        return productService.createProductInCategory(id, product);
    }

    @GetMapping("/category/readBy{ID}")
    public Category readCategoryByProductId(@PathVariable int id) {
        return productService.findCategoryByProductId(id);
    }

    @PostMapping("/categorys/updateBy{ID}")
    public Category updateCategoryByProductId(@PathVariable int id, @RequestBody Category category) {
        return productService.updateCategoryByProductId(id, category);
    }

    @PostMapping("/category/deleteBy{ID}")
    public void deleteCategoryByProductId(@PathVariable int id) {
        productService.deleteCategoryByProductId(id);
    }

    @GetMapping("/categorys/list")
    public List<Category> listAllCategories() {
        return productService.findAllCategories();
    }

    @GetMapping("/category/productlist")
    public List<Product> listAllProductsInCategory() {
        return productService.findAllProductsInCategory();
    }

 */
}

/*
package com.example.demo.ressources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // Indicates that this is a REST controller
@RequestMapping("/product")  // Sets the base URL path
public class ProductController {

    @Autowired
    private ProductService productService;  // Made private for encapsulation

    // GET localhost:8080/product
    @GetMapping  // Maps to GET HTTP method
    public List<Product> getAllProducts() {  // Renamed for clarity
        return productService.findAll();  // Assuming the method in ProductService is called 'findAll'
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {

        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}") // 2mal {id} geht da es put oder delete ist
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping("/readBy{ID}")
    public Optional<Product> readProductById(@PathVariable int id) {

        return productService.findById(id);
    }


}

 */