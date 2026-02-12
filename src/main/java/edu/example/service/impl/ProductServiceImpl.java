package edu.example.service.impl;

import edu.example.model.entity.Product;
import edu.example.repository.ProductRepository;
import edu.example.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProducts(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(existingProduct -> {

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImgUrl(updatedProduct.getImgUrl());
            existingProduct.setColor(updatedProduct.getColor());

            return productRepository.save(existingProduct);

        }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}