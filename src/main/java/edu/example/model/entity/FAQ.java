package edu.example.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FAQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String question;

    @Column(columnDefinition = "Text")
    private String answer;
}
