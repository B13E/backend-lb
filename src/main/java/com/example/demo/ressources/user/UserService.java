package com.example.demo.ressources.user;

import com.example.demo.ressources.auth.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Sucht nach einem Benutzer anhand seiner E-Mail-Adresse.
     *
     * @param email Die E-Mail-Adresse des gesuchten Benutzers.
     * @return Der gefundene Benutzer oder null, wenn kein Benutzer mit der angegebenen E-Mail-Adresse gefunden wurde.
     */
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    /**
     * Gibt eine Liste aller Benutzer in der Datenbank zurück.
     *
     * @return Eine Liste aller Benutzer.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Erstellt einen neuen Benutzer.
     *
     * @param user Die Benutzerdetails für den neuen Benutzer.
     * @return Der erstellte Benutzer.
     */
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Aktualisiert die Daten eines Benutzers anhand seiner ID.
     *
     * @param id   Die ID des zu aktualisierenden Benutzers.
     * @param user Die neuen Benutzerdaten.
     * @return Der aktualisierte Benutzer oder null, wenn der Benutzer nicht gefunden wurde.
     */
    public User update(Integer id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setId(user.getId());
            return userRepository.save(existingUser);
        }
        return null;
    }

    /**
     * Sucht nach einem Benutzer anhand seiner ID.
     *
     * @param id Die ID des gesuchten Benutzers.
     * @return Der gefundene Benutzer oder null, wenn kein Benutzer mit der angegebenen ID gefunden wurde.
     */
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * Löscht einen Benutzer anhand seiner ID.
     *
     * @param id Die ID des zu löschenden Benutzers.
     */
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * Registriert einen neuen Benutzer.
     *
     * @param user Die Benutzerdetails für den neuen Benutzer.
     * @return Der registrierte Benutzer.
     */
    public User register(User user) {
        return userRepository.save(user);
    }

    /**
     * Überprüft die Anmeldeinformationen eines Benutzers und gibt den Benutzer zurück, wenn die Anmeldeinformationen gültig sind.
     *
     * @param loginRequestDto Die Anmeldeinformationen des Benutzers.
     * @return Der angemeldete Benutzer oder null, wenn die Anmeldeinformationen ungültig sind.
     */
    public User getUserWithCredentials(LoginRequestDto loginRequestDto) {
        return userRepository.findByEmailAndPasswort(loginRequestDto.getEmail(), loginRequestDto.getPassword());
    }

    /**
     * Aktualisiert einen Benutzer und befördert ihn zum Administrator.
     *
     * @param user Der Benutzer, der zum Administrator befördert werden soll.
     * @return Der aktualisierte Benutzer mit Administratorrechten.
     */
    public User upgradeUserToAdmin(User user) {
        user.setAdmin(true);
        return userRepository.save(user);
    }
}
