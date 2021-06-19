package fr.mauritius.Backpacker.services;

import java.util.List;

import fr.mauritius.Backpacker.domain.dtos.AccountCreate;
import fr.mauritius.Backpacker.domain.dtos.AccountLogin;
import fr.mauritius.Backpacker.domain.dtos.AccountView;
import fr.mauritius.Backpacker.domain.entities.Account;
import fr.mauritius.Backpacker.security.IdToken;

public interface AccountService {

    void create(AccountCreate dto);

    AccountView getById(Long id);

    List<Account> listAllAccount();

    IdToken login(AccountLogin dto);

}
