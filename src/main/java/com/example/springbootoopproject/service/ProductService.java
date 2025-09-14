package com.example.springbootoopproject.service;

import com.example.springbootoopproject.model.Product;
import com.example.springbootoopproject.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, Product> kafkaTemplate;

    public ProductService(ProductRepository productRepository, KafkaTemplate<String, Product> kafkaTemplate) {
        this.productRepository = productRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Cacheable(value = "products", key = "#id")
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @CacheEvict(value = "products", allEntries = true)
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        kafkaTemplate.send("product-events", "product.created", savedProduct);
        return savedProduct;
    }

    @CacheEvict(value = "products", key = "#id")
    public Optional<Product> updateProduct(String id, Product product) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setPrice(product.getPrice());
                    Product updatedProduct = productRepository.save(existingProduct);
                    kafkaTemplate.send("product-events", "product.updated", updatedProduct);
                    return updatedProduct;
                });
    }

    @CacheEvict(value = "products", key = "#id")
    public boolean deleteProduct(String id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    kafkaTemplate.send("product-events", "product.deleted", product);
                    return true;
                })
                .orElse(false);
    }
}
