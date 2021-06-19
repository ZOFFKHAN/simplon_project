package fr.mauritius.Backpacker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class Test_controller {

    @GetMapping("/anonymous-only")

    public String anonymousOnly() {
	return "i am an anonymous user";
    }

    @GetMapping("/basic-only")

    public String basicOnly() {
	return "i am a basic user";
    }

    @GetMapping("/admin-only")

    public String adminOnly() {
	return "i am an admin user";
    }

}
