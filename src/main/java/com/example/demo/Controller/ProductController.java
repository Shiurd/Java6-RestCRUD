package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.ModelEntity.ModelProduct;
import com.example.demo.Repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productDAO.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        Product product = productDAO.findById(id).orElse(null);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productDAO.save(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        if (!productDAO.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        product.setId(id);
        Product updatedProduct = productDAO.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
        if (!productDAO.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productDAO.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
