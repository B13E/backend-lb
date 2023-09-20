package com.example.demo.ressources.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(String email);

    // Sie könnten dies erweitern, um auch das Passwort zu überprüfen,
    // aber denken Sie daran, in einer echten Anwendung sollten Sie niemals rohe Passwörter speichern oder vergleichen.
    User findByEmailAndPasswort(String email, String passwort);
}
