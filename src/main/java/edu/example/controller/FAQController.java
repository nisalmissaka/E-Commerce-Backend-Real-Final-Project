package edu.example.controller;

import edu.example.model.dto.FAQDTO;
import edu.example.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@CrossOrigin(origins = "https://localhost:5173")
public class FAQController {

    @Autowired
    private FAQService faqService;

    @GetMapping
    public List<FAQDTO> getAllFAQs(){
        return faqService.getAllFAQs();
    }
}
