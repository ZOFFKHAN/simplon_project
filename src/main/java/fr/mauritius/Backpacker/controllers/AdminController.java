package fr.mauritius.Backpacker.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/admin-only")
    // @Secured("ROLE_ADMIN")

    @Secured({ "ROLE_ADMIN", "ROLE_BASIC" })
    public String adminOnly() {
	return "i am an admin ";
    }

    @GetMapping("/admin-only-pre-authorize")
    // Spel : Spring Expression Language
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_BASIC')")
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_BASIC')")
    public String preauthorizeadminOnly() {
	// String name = service.getSomething
	// avant de retourner quelque chose
	return "i am a preauthorizeadmin ";
    }

    // acces à un end point si deux roles

}
