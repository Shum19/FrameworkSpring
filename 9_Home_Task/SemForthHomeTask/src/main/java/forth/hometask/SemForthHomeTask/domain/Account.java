package forth.hometask.SemForthHomeTask.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameofsite")
    private String nameOfSite;
    @Column(name = "fullwebaddress")
    private String fullWebAddress;
    @Column
    private String login;
    @Column
    private String password;

//    public Account(String nameOfSite, String fullWebAddress, String login, String password) {
//        this.id = id;
//        this.nameOfSite = nameOfSite;
//        this.fullWebAddress = fullWebAddress;
//        this.login = login;
//        this.password = password;
//    }


    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfSite() {
        return nameOfSite;
    }

    public void setNameOfSite(String nameOfSite) {
        this.nameOfSite = nameOfSite;
    }

    public String getFullWebAddress() {
        return fullWebAddress;
    }

    public void setFullWebAddress(String fullWebAddress) {
        this.fullWebAddress = fullWebAddress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
