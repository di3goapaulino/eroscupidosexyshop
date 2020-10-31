package com.eruscupisoss.app.resources;

import java.net.URI;
import java.util.List;

import com.eruscupisoss.app.dto.UserDTO;
import com.eruscupisoss.app.entities.User;
import com.eruscupisoss.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {

        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    ResponseEntity<UserDTO> insert(@RequestBody User user){
        user = service.insert(user);

        UserDTO userDto = new UserDTO(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody User user){

        UserDTO userDto = service.update(id, user);

        return ResponseEntity.ok().body(userDto);
    }
    

}
