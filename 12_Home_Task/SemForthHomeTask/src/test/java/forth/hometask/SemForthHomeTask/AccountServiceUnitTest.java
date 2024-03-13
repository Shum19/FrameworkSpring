package forth.hometask.SemForthHomeTask;

import forth.hometask.SemForthHomeTask.Service.AccountService;
import forth.hometask.SemForthHomeTask.domain.Account;
import forth.hometask.SemForthHomeTask.repository.AccountRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AccountServiceUnitTest {
    AccountRepo accountRepo = mock(AccountRepo.class);
    AccountService accountService = new AccountService(accountRepo);
    @Test
    @DisplayName("Default Unit Save Method Test")
    public void saveUnitTest(){
        Account account = new Account();
        account.setId(1L);
        account.setNameOfSite("gmail");
        account.setFullWebAddress("mail.google.com");
        account.setLogin("ivan@gmail.com");
        account.setPassword("secret");
//        Добавляем в репозиторий объект
//        1
        accountService.saveAccount(account);
//        2
        accountService.saveAccount(account);
//        3
        accountService.saveAccount(account);

//        Проверяем что метод save в interface AccountRepo был вызван 3 раз
        verify(accountRepo, times(3)).save(account);

    }
    @Test
    @DisplayName("Default Unit Delete Method Test")
    public void deeleteUnitTest(){
        Account account = new Account();
        account.setId(1L);
        account.setNameOfSite("gmail");
        account.setFullWebAddress("mail.google.com");
        account.setLogin("ivan@gmail.com");
        account.setPassword("secret");
//        Добавляем в репозиторий объект
//        1
        accountService.deleteByNameOfSite("gmail");
//        2
        accountService.deleteByNameOfSite("gmail");
//        3
        accountService.deleteByNameOfSite("gmail");

//        Проверяем что метод delete в interface AccountRepo был вызван 3 раз
        verify(accountRepo, times(3)).deleteByNameOfSite("gmail");
    }
}
