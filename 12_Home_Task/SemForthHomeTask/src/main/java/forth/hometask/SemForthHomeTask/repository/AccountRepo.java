package forth.hometask.SemForthHomeTask.repository;

import forth.hometask.SemForthHomeTask.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Account findByNameOfSite(String nameOfSite);
    void deleteByNameOfSite(String nameOfSite);

}
