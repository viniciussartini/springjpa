package br.com.example.springjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.example.springjpa.entities.User;
import br.com.example.springjpa.repositories.UserRepository;
import br.com.example.springjpa.services.exceptions.ControllerNotFoundException;
import br.com.example.springjpa.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        return userById.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        try {
            User entity = userRepository.getReferenceById(id);
            updateEntity(entity, user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException(id);
        }
    }

    private void updateEntity(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
