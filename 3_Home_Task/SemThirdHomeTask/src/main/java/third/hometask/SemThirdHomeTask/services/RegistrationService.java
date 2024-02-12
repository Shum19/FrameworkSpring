package third.hometask.SemThirdHomeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import third.hometask.SemThirdHomeTask.domain.User;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    public String processRegistration(String name, int age, String email){
        User user = userService.createUser(name,age, email);

//        Метод использует обычный список из Class UserRepository
//        dataProcessingService.addUserToList(user);

//        Метод использует Class  UserRepo на H2
        dataProcessingService.addUserToRepo(user);
        return "Registered "+user.getName();
    }
}
