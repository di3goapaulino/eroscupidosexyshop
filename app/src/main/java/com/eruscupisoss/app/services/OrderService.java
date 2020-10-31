package com.eruscupisoss.app.services;

import java.util.List;
import java.util.Optional;

import com.eruscupisoss.app.entities.Order;
import com.eruscupisoss.app.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    };

    public Order findById(Long Id) {
        
        Optional<Order> user = repository.findById(Id);
        return user.get();
    };
    
}
