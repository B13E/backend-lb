package com.example.demo.ressources.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Sucht nach einem Benutzer anhand seiner E-Mail-Adresse.
     *
     * @param email Die E-Mail-Adresse des gesuchten Benutzers.
     * @return Der gefundene Benutzer oder null, wenn kein Benutzer mit der angegebenen E-Mail-Adresse gefunden wurde.
     */
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(String email);

    /**
     * Sucht nach einem Benutzer anhand seiner E-Mail-Adresse und seines Passworts.
     * Beachten Sie, dass es sicherer ist, Passwörter in einer sicheren Form zu speichern und zu überprüfen,
     * anstatt rohe Passwörter zu vergleichen.
     *
     * @param email    Die E-Mail-Adresse des gesuchten Benutzers.
     * @param passwort Das Passwort des gesuchten Benutzers.
     * @return Der gefundene Benutzer oder null, wenn kein Benutzer mit den angegebenen Anmeldeinformationen gefunden wurde.
     */
    User findByEmailAndPasswort(String email, String passwort);
}
