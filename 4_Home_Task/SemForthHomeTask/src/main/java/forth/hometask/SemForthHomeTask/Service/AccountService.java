package forth.hometask.SemForthHomeTask.Service;

import forth.hometask.SemForthHomeTask.domain.Account;
import forth.hometask.SemForthHomeTask.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    public List<Account> findAll(){
        return this.accountRepo.getAccountLibraryList();
    }
    public Account findByNameOfSite(String nameOfSite){
        for (Account account : findAll()) {
            if (account.getNameOfSite().equalsIgnoreCase(nameOfSite)) {
                return account;
            }
        }
        return null;
    }
    public void saveAccount(Account account){
        accountRepo.addAccount(account);
    }
}
