package com.example.demo.ressources.user;

import com.example.demo.ressources.auth.TokenWrapper;
import com.example.demo.ressources.auth.dto.LoginRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name="User", description = "Controller für User")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Diese Methode gibt alle Benutzer ab.
     *
     * @return Eine Liste aller Benutzer.
     */
    @Operation(summary = "Alle Benutzer abrufen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Erfolgreich alle Benutzer abgerufen")
    })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    /**
     * Diese Methode erstellt einen neuen Benutzer.
     *
     * @param user Die Details des zu erstellenden Benutzers.
     * @return Der erstellte Benutzer.
     */
    @Operation(summary = "Einen neuen Benutzer erstellen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Benutzer erfolgreich erstellt")
    })
    @PostMapping("/create")
    public User createUser(@RequestBody @Parameter(description = "Details des zu erstellenden Benutzers.") User user) {
        return userService.create(user);
    }

    /**
     * Diese Methode registriert einen neuen Benutzer.
     *
     * @param user Die Details des zu registrierenden Benutzers.
     * @return Der registrierte Benutzer.
     */
    @Operation(summary = "Einen neuen Benutzer registrieren")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Benutzer erfolgreich registriert")
    })
    @PostMapping("/auth/register")
    public User register(@RequestBody @Parameter(description = "Details des zu registrierenden Benutzers.") User user) {
        return userService.register(user);
    }

    /**
     * Diese Methode ermöglicht das Einloggen eines Benutzers und gibt ein Token zurück.
     *
     * @param loginRequestDto Anmeldeinformationen des Benutzers.
     * @return Ein TokenWrapper, wenn das Einloggen erfolgreich war, sonst null.
     */
    @Operation(summary = "Einloggen eines Benutzers und Rückgabe eines Tokens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Einloggen erfolgreich"),
            @ApiResponse(responseCode = "401", description = "Ungültige Anmeldeinformationen")
    })
    @PostMapping("/auth/login")
    public TokenWrapper login(@RequestBody @Parameter(description = "Anmeldeinformationen des Benutzers.") LoginRequestDto loginRequestDto) {
        User user = userService.getUserWithCredentials(loginRequestDto);
        if (user != null) {
            TokenWrapper tokenWrapper = new TokenWrapper();
            return tokenWrapper;
        } else {
            return null;
        }
    }

    /**
     * Diese Methode aktualisiert einen Benutzer anhand seiner ID.
     *
     * @param id   Die ID des zu aktualisierenden Benutzers.
     * @param user Neue Daten für den Benutzer.
     * @return Der aktualisierte Benutzer.
     */
    @Operation(summary = "Einen Benutzer anhand seiner ID aktualisieren")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Benutzer erfolgreich aktualisiert"),
            @ApiResponse(responseCode = "404", description = "Benutzer nicht gefunden")
    })

    @PutMapping("/{id}")
    public User updateUser(@PathVariable @Parameter(description = "ID des zu aktualisierenden Benutzers.") Integer id,
                           @RequestBody @Parameter(description = "Neue Daten für den Benutzer.") User user) {
        return userService.update(id, user);
    }

    /**
     * Diese Methode aktualisiert einen Benutzer und befördert ihn zum Administrator.
     *
     * @param user Details des zu aktualisierenden Benutzers.
     * @return Der aktualisierte Benutzer.
     */
    @Operation(summary = "Einen Benutzer zum Admin upgraden")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Benutzer erfolgreich zum Admin hochgestuft"),
            @ApiResponse(responseCode = "404", description = "Benutzer nicht gefunden")
    })
    @PutMapping("/user/upgrade")
    public User upgradeUserToAdmin(@RequestBody @Parameter(description = "Details des zu aktualisierenden Benutzers.") User user) {
        return userService.upgradeUserToAdmin(user);
    }

    /**
     * Diese Methode löscht einen Benutzer anhand seiner ID.
     *
     * @param id Die ID des zu löschenden Benutzers.
     */
    @Operation(summary = "Einen Benutzer anhand seiner ID löschen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Benutzer erfolgreich gelöscht"),
            @ApiResponse(responseCode = "404", description = "Benutzer nicht gefunden")
    })
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Parameter(description = "ID des zu löschenden Benutzers.") Integer id) {
        userService.deleteById(id);
    }
}
