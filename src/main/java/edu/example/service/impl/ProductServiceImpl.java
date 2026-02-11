package edu.example.service.impl;

import edu.example.model.entity.Product;
import edu.example.repository.ProductRepository;
import edu.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product) ;

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
