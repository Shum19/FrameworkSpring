package forth.hometask.SemForthHomeTask.domain;

import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class Account {
    private int id;
    private String nameOfSite;
    private String fullWebAddress;
    private String login;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
