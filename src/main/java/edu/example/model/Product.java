package edu.example.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private String color;
    private String size;

}
