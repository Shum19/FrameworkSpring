package seventh.hometask.authorizationserver.SemSeventhHomeTask.services;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import seventh.hometask.authorizationserver.SemSeventhHomeTask.domain.MyUser;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        MyUser user = userService.findByName(userName);
        if (user == null){
            throw new UsernameNotFoundException("User not found " + userName) ;
        }
        UserDetails userDetails = User.builder()
                                    .username(user.getName())
                                    .password(user.getPassword())
                                    .roles(user.getRole())
                                    .build();
        System.out.println(userDetails.getPassword());
        return userDetails;
    }
}
