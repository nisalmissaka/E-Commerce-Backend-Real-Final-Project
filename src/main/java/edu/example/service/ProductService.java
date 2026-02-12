package edu.example.service;

import edu.example.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product updateProducts(Long id, Product product);

}
