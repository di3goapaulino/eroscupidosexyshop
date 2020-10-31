package com.eruscupisoss.app.resources;

import java.util.List;

import com.eruscupisoss.app.entities.Product;
import com.eruscupisoss.app.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {

        List<Product> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product Product = service.findById(id);
		return ResponseEntity.ok().body(Product);
	}
}