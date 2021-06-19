package fr.mauritius.Backpacker.services;

import java.util.List;

import fr.mauritius.Backpacker.domain.dtos.CustomerCreate;
import fr.mauritius.Backpacker.domain.dtos.CustomerView;
import fr.mauritius.Backpacker.domain.entities.Customer;

public interface CustomerService {

    List<Customer> listAllCustomer();

    CustomerView getById(Long id);

    void create(CustomerCreate dto);

    void Customer(Long id);

}
