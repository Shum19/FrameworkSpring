package second.hometask.SemTwoCRUD.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import second.hometask.SemTwoCRUD.model.User;
import second.hometask.SemTwoCRUD.services.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/user-delete/{id}")
    public String deleteById(User user){
        userService.deleteByID(user.getId());
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(User user){
        return "user-update";
    }
    @PostMapping("user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }


}
