package com.example.productcatalog.services;

import com.example.productcatalog.entities.Product;
import com.example.productcatalog.exceptions.ResourceNotFoundException;
import com.example.productcatalog.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);



    public Product createProduct(Product product) {
        logger.info("Creating product: {}", product);
        Product createdProduct = productRepository.save(product);
        logger.info("Product created successfully: {}", createdProduct);
        return createdProduct;
    }

    public Product getProductById(Long id) {
        logger.info("Fetching product with id: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Product not found with id: {}", id);
                    return new ResourceNotFoundException("Product not found");
                });
    }

    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        logger.info("Products retrieved successfully, count: {}", products.size());
        return products;
    }

    public Product updateProduct(Long id, Product productDetails) {
        logger.info("Updating product with id: {}", id);
        Product existingProduct = getProductById(id);
        existingProduct.setName(productDetails.getName());
        existingProduct.setBrand(productDetails.getBrand());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setQuantity(productDetails.getQuantity());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setSku(productDetails.getSku());
        existingProduct.setManufacturer(productDetails.getManufacturer());
        Product updatedProduct = productRepository.save(existingProduct);
        logger.info("Product updated successfully: {}", updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(Long id) {
        logger.info("Deleting product with id: {}", id);
        productRepository.deleteById(id);
        logger.info("Product deleted successfully with id: {}", id);
    }

    public List<Product> searchProducts(String name, String category, BigDecimal minPrice, BigDecimal maxPrice) {
        logger.info("Searching products with criteria - name: {}, category: {}, minPrice: {}, maxPrice: {}", name, category, minPrice, maxPrice);

        // Search by name
        if (name != null && !name.isEmpty()) {
            List<Product> products = productRepository.findByNameContaining(name);
            logger.info("Search by name completed, products found: {}", products.size());
            return products;
        }

        // Filter by category
        if (category != null && !category.isEmpty()) {
            List<Product> products = productRepository.findByCategory(category);
            logger.info("Search by category completed, products found: {}", products.size());
            return products;
        }

        // Filter by price range
        if (minPrice != null && maxPrice != null) {
            List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
            logger.info("Search by price range completed, products found: {}", products.size());
            return products;
        }

        // If no filter applied, return all products
        List<Product> products = productRepository.findAll();
        logger.info("No filters applied, returning all products, count: {}", products.size());
        return products;
    }
}
