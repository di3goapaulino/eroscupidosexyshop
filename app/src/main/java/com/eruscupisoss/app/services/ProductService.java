package com.eruscupisoss.app.services;

import java.util.List;
import java.util.Optional;

import com.eruscupisoss.app.entities.Product;
import com.eruscupisoss.app.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    };

    public Product findById(Long Id) {
        
        Optional<Product> user = repository.findById(Id);
        return user.get();
    };
    
}
