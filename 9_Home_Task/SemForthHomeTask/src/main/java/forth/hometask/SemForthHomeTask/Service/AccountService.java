package forth.hometask.SemForthHomeTask.Service;

import forth.hometask.SemForthHomeTask.domain.Account;
import forth.hometask.SemForthHomeTask.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    public List<Account> findAll(){
        return this.accountRepo.findAll();
    }
    public Account findByNameOfSite(String nameOfSite){
        return accountRepo.findByNameOfSite(nameOfSite);
    }
    public void saveAccount(Account account){
        accountRepo.save(account);
    }
}
