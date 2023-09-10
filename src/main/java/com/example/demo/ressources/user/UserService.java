package com.example.demo.ressources.user;

import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(int id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setId(user.getId());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}
