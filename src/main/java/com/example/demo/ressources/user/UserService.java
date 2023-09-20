package com.example.demo.ressources.user;

import com.example.demo.ressources.auth.dto.LoginRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
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

    public User register(User user) {
        return userRepository.save(user);
    }

    public User getUserWithCredentials(LoginRequestDto loginRequestDto) {
        return userRepository.findByEmailAndPasswort(loginRequestDto.getEmail(), loginRequestDto.getPassword());
    }

    public User upgradeUserToAdmin(User user) {
        user.setAdmin(true); // Benutzer als Admin festlegen
        return userRepository.save(user);
    }
}
