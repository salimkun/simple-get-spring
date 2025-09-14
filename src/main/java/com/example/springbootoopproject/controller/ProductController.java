package com.example.springbootoopproject.controller;

import com.example.springbootoopproject.dto.ApiResponse;
import com.example.springbootoopproject.model.Product;
import com.example.springbootoopproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse.success("Products retrieved successfully", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable String id) {
        return productService.getProductById(id)
                .map(product -> ResponseEntity.ok(ApiResponse.success("Product retrieved successfully", product)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.notFound("Product not found with id: " + id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@Valid @RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created("Product created successfully", createdProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable String id, @Valid @RequestBody Product product) {
        return productService.updateProduct(id, product)
                .map(updatedProduct -> ResponseEntity.ok(ApiResponse.success("Product updated successfully", updatedProduct)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.notFound("Product not found with id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProduct(@PathVariable String id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.ok(ApiResponse.success("Product deleted successfully", "Product with id " + id + " has been deleted"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.notFound("Product not found with id: " + id));
        }
    }
}
