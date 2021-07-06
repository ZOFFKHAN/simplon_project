package fr.mauritius.Backpacker.services;

import java.util.List;

//import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.mauritius.Backpacker.domain.dtos.AccountCreate;
import fr.mauritius.Backpacker.domain.dtos.AccountLogin;
import fr.mauritius.Backpacker.domain.dtos.AccountView;
import fr.mauritius.Backpacker.domain.entities.Account;
import fr.mauritius.Backpacker.domain.entities.Role;
import fr.mauritius.Backpacker.repositories.AccountRepository;
import fr.mauritius.Backpacker.repositories.RoleRepository;
import fr.mauritius.Backpacker.security.BadCredentialsException;
import fr.mauritius.Backpacker.security.IdToken;
import fr.mauritius.Backpacker.security.TokenProvider;

@Service
public class AccountServiceImpl implements AccountService {
    private final PasswordEncoder encoder;
    private final TokenProvider provider;
    private final AccountRepository accounts;
    private final RoleRepository roles;

    public AccountServiceImpl(PasswordEncoder encoder, TokenProvider provider, AccountRepository accounts,
	    RoleRepository roles) {

	this.encoder = encoder;
	this.provider = provider;
	this.accounts = accounts;
	this.roles = roles;
    }

    @Override
    public AccountView getById(Long id) {

	Account account = accounts.findById(id).get();
	AccountView view = new AccountView();
	view.setUsername(account.getUsername());

	view.setPassword(account.getPassword());
//	view.setAdefault(account.isAdefault());
//	view.setRolestatus(account.isRolestatus());
	return view;
    }

    @Override
    public void create(AccountCreate dto) {

	Account account = new Account();
	account.setUsername(dto.getUsername());
	String raw = dto.getPassword();
	// raw password en brut
	String encoded = encoder.encode(raw);
	// bean encoder crypte le password
	account.setPassword(encoded);

	// account.setPassword(dto.getPassword());
	account.setEnabled(true);
	Role defaultRole = roles.findByByDefaultTrue();
	account.setRole(defaultRole);

	accounts.save(account);
    }

    @Override
    public List<Account> listAllAccount() {
	// TODO Auto-generated method stub
	return accounts.findAll();
    }

    @Override
    public IdToken login(AccountLogin dto) {
	String username = dto.getUsername();
//	Optional<Account> entity = accounts
//		.findByUsernameAndEnabledTrue(username);
//	if (entity.isPresent()) {
//	    System.out.println("Login success!");
//	} else {
//	    // throw new RuntimeException();
//	    // try catch ou propager l'exception.get
//	    System.out.println("Account not found!");
//	}

	// credential === username/password

	// change lamda to optionel
	Account entity = accounts.findByUsernameAndEnabledTrue(username)
		.orElseThrow(() -> new BadCredentialsException("username not found: " + username));
	// user name ok what about password
	String encoded = entity.getPassword();
	String raw = dto.getPassword();

	// ! if doesn't match
	// manage exception first
	if (!encoder.matches(raw, encoded)) {
	    throw new BadCredentialsException("bad password for username : " + username);
	}

	// System.out.println(" login success, generate token");
	// Create a list with the account role's code:
	List<String> authorities = List.of(entity.getRole().getCode());
	// Return an ID token (oauth 2) with the subject and authorities:
	return provider.idToken(entity.getId(), username, authorities);

    }

}
