package com.eruscupisoss.app.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.eruscupisoss.app.dto.UserDTO;
import com.eruscupisoss.app.entities.User;
import com.eruscupisoss.app.repositories.UserRepository;
import com.eruscupisoss.app.services.exceptions.DatabaseException;
import com.eruscupisoss.app.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {

        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserDTO update(Long id, User user) {

        try {
            User entity = repository.getOne(id);
            updateData(entity, user);

            UserDTO userDTO = new UserDTO(repository.save(entity));
            return userDTO;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {

        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
        entity.setPhone(user.getPhone());

    }
}
