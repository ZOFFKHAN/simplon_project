package fr.mauritius.Backpacker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mauritius.Backpacker.domain.dtos.AccountCreate;
import fr.mauritius.Backpacker.domain.dtos.AccountLogin;
import fr.mauritius.Backpacker.domain.dtos.AccountView;
import fr.mauritius.Backpacker.domain.entities.Account;
import fr.mauritius.Backpacker.security.IdToken;
import fr.mauritius.Backpacker.services.AccountService;

@RestController
@RequestMapping("/accounts")

public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
	this.service = service;
    }

    @GetMapping("/{id}")
    // public SkillCreate getById(@PathVariable("id") Long id) {
    public AccountView getById(@PathVariable("id") Long id) {

	return service.getById(id);
    }

    @PostMapping("")
    public void create(@Valid @RequestBody AccountCreate dto) {
	service.create(dto);
	System.out.println(dto);
    }

    @PostMapping("/login")
    public IdToken login(@Valid @RequestBody AccountLogin dto) {
	return service.login(dto);
    }

    @GetMapping("")
    public List<Account> list() {
	return service.listAllAccount();
    }

}
