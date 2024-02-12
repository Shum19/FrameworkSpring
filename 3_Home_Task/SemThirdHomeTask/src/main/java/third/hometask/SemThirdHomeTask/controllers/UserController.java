package third.hometask.SemThirdHomeTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import third.hometask.SemThirdHomeTask.domain.User;
import third.hometask.SemThirdHomeTask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping()
    public List<User> userList(){

//        //    Методы для  Class UserRepository
//        return registrationService.getDataProcessingService().getRepo().getUserList();

//        Методы для  Class UserRepo
        return registrationService.getDataProcessingService().getRepo();
    }
    @PostMapping("/body/{name}/{age}/{email}")
    public String userAddFromBody(@PathVariable String name, @PathVariable int age, @PathVariable String email){
        return registrationService.processRegistration(name, age, email);
    }

    // 1) В классе UserController добавить обработчик userAddFromParam извлекающий
    // данные для создания пользователя из параметров HTTP запроса
    @PostMapping()
    public String addUserFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        return registrationService.processRegistration(name,age,email);
    }

}
