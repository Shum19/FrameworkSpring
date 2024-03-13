package forth.hometask.SemForthHomeTask.Controller;

import forth.hometask.SemForthHomeTask.Service.AccountService;
import forth.hometask.SemForthHomeTask.Service.FileGateWay;
import forth.hometask.SemForthHomeTask.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    private FileGateWay fileGateWay;
    @Autowired
    private AccountService accountService;
    public AccountController(AccountService accountService, FileGateWay fileGateWay) {
        this.accountService = accountService;
        this.fileGateWay = fileGateWay;
    }
    @GetMapping("/accounts")
    public String findAll(Model model){
        List <Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }
    @GetMapping("/create-account")
    public String accountForm(Account account){
        return "create-account";
    }




    @PostMapping("/create-account")
    public String addAccount(Long id, Account account){
        account.setId(id);
        accountService.saveAccount(account);
        fileGateWay.writeToFile(account.getLogin()+".txt", account.getLogin()+" "+account.getPassword());
        return "redirect:/accounts";
    }

}
