package third.hometask.SemThirdHomeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import third.hometask.SemThirdHomeTask.domain.User;

@Service
public class UserService {
    // Способ 1: @Autowired самостоятельно создаст экземпляр Notification Service и положит его в этот класс
    @Autowired
    private NotificationService notificationService;

    // Способ 2: Определить конструктор UserService и лучше делать через конструктор

//    public UserService(NotificationService notificationService){
//        this.notificationService = notificationService
//    }
    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);
        return user;
    }
}
