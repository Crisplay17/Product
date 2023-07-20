package com.spring.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product productDetails) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            product.setDescription(productDetails.getDescription());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}

