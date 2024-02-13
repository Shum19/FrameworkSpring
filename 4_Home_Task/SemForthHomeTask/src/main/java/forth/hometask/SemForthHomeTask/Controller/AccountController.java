package forth.hometask.SemForthHomeTask.Controller;

import forth.hometask.SemForthHomeTask.Service.AccountService;
import forth.hometask.SemForthHomeTask.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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
    public String addAccount(Account account){
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }
}
