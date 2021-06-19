package fr.mauritius.Backpacker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.mauritius.Backpacker.domain.dtos.CustomerCreate;
import fr.mauritius.Backpacker.domain.dtos.CustomerView;
import fr.mauritius.Backpacker.domain.entities.Account;
import fr.mauritius.Backpacker.domain.entities.Customer;
import fr.mauritius.Backpacker.repositories.AccountRepository;
import fr.mauritius.Backpacker.repositories.CustomerRepository;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    // @Override

    private final CustomerRepository customers;
    private final AccountRepository accountRepo;

    public CustomerServiceImpl(CustomerRepository customers, AccountRepository accountRepo) {
	super();
	this.customers = customers;
	this.accountRepo = accountRepo;
    }

    public List<Customer> listAllCustomer() {
	return customers.findAll();

    }

    @Override
    public CustomerView getById(Long id) {
	Customer customer = customers.getById(id).get();
	CustomerView view = new CustomerView();

	view.setFirstname(customer.getFirstname());
	view.setLastname(customer.getLastname());
	view.setEmail(customer.getEmail());
	// view.setMainAccountId(view.getMainAccount().getId());
	view.setMainAccountId(customer.getMainAccount().getId());

	Account account = accountRepo.getOne(customer.getMainAccount().getId());
	customer.setMainAccount(account);

	view.setUseraccount(account.getUsername());

	return view;
    }

    @Override
    public void create(CustomerCreate dto) {
	System.out.println("call in service");
	Customer customer = new Customer();
	customer.setEmail(dto.getEmail());
	customer.setFirstname(dto.getFirstname());
	customer.setLastname(dto.getLastname());

	Long mainAccountId = dto.getMainAccountId();

	Account account = accountRepo.getOne(mainAccountId);
	customer.setMainAccount(account);

	customers.save(customer);

    }

    @Override
    public void Customer(Long id) {

	customers.deleteByid(id);

    }

}
