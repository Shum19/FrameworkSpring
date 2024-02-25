package forth.hometask.SemForthHomeTask.repository;

import forth.hometask.SemForthHomeTask.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByNameOfSite(String nameOfSite);

//    private List<Account> accountList;
//
//    public AccountRepo(List<Account> accountList) {
//        this.accountList = accountList;
//    }
//
//    public List<Account> getAccountLibraryList() {
//        return accountList;
//    }
//    public void addAccount(Account account){
//
//        this.accountList.add(account);
//    }

}
