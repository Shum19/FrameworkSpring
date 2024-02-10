package second.hometask.SemTwoCRUD.model;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private int id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return id == user1.id && Objects.equals(firstName,user1.getFirstName()) && Objects.equals(lastName, user1.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
