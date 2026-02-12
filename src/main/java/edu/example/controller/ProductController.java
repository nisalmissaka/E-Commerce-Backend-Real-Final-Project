package edu.example.controller;


import edu.example.model.entity.Product;
import edu.example.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
   private final  ProductService productService ;

   @PostMapping("/add")
    public Product save( @RequestBody Product product){
       return productService.saveProduct(product);
   }
   @GetMapping("/get-all")
    public List <Product> getAll(){
       return productService.getAllProducts();
   }
   @PutMapping("/update/{id}")
    public Product updateProduct (@PathVariable Long id ,@RequestBody Product product){
       return productService.updateProducts(id,product);
   }
}
