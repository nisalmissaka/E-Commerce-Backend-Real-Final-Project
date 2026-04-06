package edu.example.service.impl;

import edu.example.model.dto.FAQDTO;
import edu.example.model.entity.FAQ;
import edu.example.repository.FAQRepository;
import edu.example.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQRepository faqRepository;

    @Override
    public List<FAQDTO> getAllFAQs() {
        List<FAQ> faqs = faqRepository.findAll();
        return faqs.stream().map(faq -> {
            FAQDTO dto = new FAQDTO();
            dto.setId(faq.getId());
            dto.setCategory(faq.getCategory());
            dto.setQuestion(faq.getQuestion());
            dto.setAnswer(faq.getAnswer());
            return dto;
        }).collect(Collectors.toList());
    }

}
