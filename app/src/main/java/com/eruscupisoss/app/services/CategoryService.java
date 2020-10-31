package com.eruscupisoss.app.services;

import java.util.List;
import java.util.Optional;

import com.eruscupisoss.app.entities.Category;
import com.eruscupisoss.app.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    };

    public Category findById(Long Id) {
        
        Optional<Category> user = repository.findById(Id);
        return user.get();
    };
    
}
