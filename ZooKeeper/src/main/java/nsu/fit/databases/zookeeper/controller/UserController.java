package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String forUser() {
        return "This page is for user!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String forAdmin() {
        return "This page is for admin!";
    }

    @GetMapping("/all")
    public String forAll() {
        return "This page is for all!";
    }
}
