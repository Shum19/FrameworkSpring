package forth.hometask.SemForthHomeTask.Service;

import forth.hometask.SemForthHomeTask.domain.Account;
import forth.hometask.SemForthHomeTask.repository.AccountRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AccountService {
@Autowired
    AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    public List<Account> findAll(){
        return accountRepo.findAll();
    }
    public Account findById(Long id){
        return accountRepo.findById(id).orElse(null);
    }
    public Account findByNameOfSite(String nameOfSite){
        return accountRepo.findByNameOfSite(nameOfSite);
    }


    public Account saveAccount(Account account){
        return accountRepo.save(account);
    }

     public void deleteByNameOfSite(String nameOfSite){
        accountRepo.deleteByNameOfSite(nameOfSite);
     }
     public void deleteById(Long id){accountRepo.deleteById(id);}





}
