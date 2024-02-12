package third.hometask.SemThirdHomeTask.services;

import org.springframework.stereotype.Service;
import third.hometask.SemThirdHomeTask.domain.User;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("A new User has been created " + user.getName());
    }
    public void sendNotification(String s){
        System.out.println(s);
    }
}
