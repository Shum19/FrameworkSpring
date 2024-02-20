package seventh.hometask.resourceserver.SemSeventhHomeTask;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println(bCryptPasswordEncoder.encode("1234"));
        System.out.println(bCryptPasswordEncoder.matches("0123", "$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG"));
        System.out.println(bCryptPasswordEncoder.matches("John", "$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG"));

    }
}
