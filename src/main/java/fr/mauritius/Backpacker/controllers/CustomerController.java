package fr.mauritius.Backpacker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mauritius.Backpacker.domain.dtos.CustomerCreate;
import fr.mauritius.Backpacker.domain.dtos.CustomerView;
import fr.mauritius.Backpacker.domain.entities.Customer;
import fr.mauritius.Backpacker.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
	this.service = service;
    }

    @GetMapping("")
    public List<Customer> list() {
	return service.listAllCustomer();
    }

    @GetMapping("/{id}")
    public CustomerView getById(@PathVariable("id") Long id) {
	return service.getById(id);
    }

    @PostMapping

    public void create(@RequestBody @Valid CustomerCreate dto) {
	service.create(dto);
	System.out.println(dto);
    }

    @DeleteMapping("/{id}")
    public void Customer(@PathVariable("id") Long id) {
	service.Customer(id);

    }

}
