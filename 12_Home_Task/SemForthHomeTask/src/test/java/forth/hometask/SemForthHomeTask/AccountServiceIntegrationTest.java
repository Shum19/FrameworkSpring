package forth.hometask.SemForthHomeTask;

import forth.hometask.SemForthHomeTask.Service.AccountService;
import forth.hometask.SemForthHomeTask.domain.Account;
import forth.hometask.SemForthHomeTask.repository.AccountRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;



@SpringBootTest
public class AccountServiceIntegrationTest {
    @Mock
    AccountRepo accountRepo;
    @Autowired
    AccountService accountService;


    @Test
    @DisplayName("Save Method Test")
    public void accountSaveTest(){
        Account account = new Account();
        account.setId(1L);
        account.setNameOfSite("gmail");
        account.setFullWebAddress("mail.google.com");
        account.setLogin("ivan@gmail.com");
        account.setPassword("secret");
//        Добавляем в репозиторий объект
        accountService.saveAccount(account);
//        Проверяем репозиторий на наличие добавленного объекта. Так как
        assertThat(accountService.findAll()).hasSize(1);
    }



    @Test
    @DisplayName("Delete By Id Meethod")
    public void deleteAccountTest(){
        Account account = new Account();
        account.setId(1L);
        account.setNameOfSite("gmail");
        account.setFullWebAddress("mail.google.com");
        account.setLogin("ivan@gmail.com");
        account.setPassword("secret");
//        Добавляем в репозиторий объект
        accountService.saveAccount(account);

//        Удаляем объект по id из репозитория
        accountService.deleteById(1L);

//        Проверяем репозиторий на наличие добавленного объекта. Так как
        assertThat(accountService.findAll()).hasSize(0);
    }
}
