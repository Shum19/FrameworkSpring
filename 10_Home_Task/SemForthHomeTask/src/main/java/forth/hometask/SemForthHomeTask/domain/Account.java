package forth.hometask.SemForthHomeTask.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.net.URL;

@Entity
@Data
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nameOfSite;
    @Column
    private String fullWebAddress;
    @Column
    private String login;
    @Column
    private String password;
}

