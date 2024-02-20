package seventh.hometask.authorizationserver.SemSeventhHomeTask.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
