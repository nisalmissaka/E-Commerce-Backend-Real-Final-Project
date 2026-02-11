package edu.example.service;

import edu.example.model.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product saveProduct(Product product);

}
