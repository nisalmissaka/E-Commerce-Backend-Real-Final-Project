package edu.example.controller;


import edu.example.model.entity.Product;
import edu.example.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
   private final  ProductService productService ;

   @PostMapping("/add")
    public Product save( @RequestBody Product product){
       return productService.saveProduct(product);
   }
   @GetMapping
    public List <Product> getAll(){
       return productService.getAllProducts();
   }
}
