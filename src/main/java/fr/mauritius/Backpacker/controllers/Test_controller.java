package fr.mauritius.Backpacker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mauritius.Backpacker.security.SecurityHelper;

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
	return "i am an admin ";
    }

//    @GetMapping("/manager-only")
//
//    public String managerOnly() {
//	return "i am a manager";
//    }

    @GetMapping("/basic-admin")

    public String basicadminOnly() {
	return "i am an admin or a basic user";
    }

//    @GetMapping("/Auth_user")
//
//    public String AuthuserOnly(JwtAuthenticationToken token) {
//
//	// accéder au bean dans sécurity confg
//
//	return "Auth_user my_username is " + token.getName();
//    }

    @GetMapping("/Auth_user")

    public String AuthuserOnly() {

	// utilise la securityhelper
	String username = SecurityHelper.username();
	Long accountId = SecurityHelper.accountid();
	return "Auth_user my_username is " + username + " accountid is  " + accountId;
    }

    @GetMapping("/manager-admin")

    public String manageradminOnly() {
	return "manager-admin";
    }

}
