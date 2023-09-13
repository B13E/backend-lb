package com.example.demo.ressources.user;

import com.example.demo.ressources.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(255)")
    private String benutzername;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String passwort;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date geburtstag;

}

/*
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;

    public List<String> getRoles() {
        List<String> hardcodedRoles = new ArrayList<>();
        hardcodedRoles.add("ROLE_ADMIN");
        return hardcodedRoles;
    }

    public String getUsername() {
        return null;
    }

    public String getPassword() {
        return null;
    }
}
 */
