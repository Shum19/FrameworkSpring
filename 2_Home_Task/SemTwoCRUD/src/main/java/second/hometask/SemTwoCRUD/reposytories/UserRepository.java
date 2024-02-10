package second.hometask.SemTwoCRUD.reposytories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import second.hometask.SemTwoCRUD.model.User;

import java.util.List;
@Repository
public class UserRepository {
    private  final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }
    public User save(User user){
        String querySql = "INSERT INTO userTable (firstName,lastName) VALUES (?,?)";
        jdbc.update(querySql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * 1) В класс UserRepository добавить метод public void deleteById(int id)
     * (подсказка: SQL запрос "DELETE FROM userTable WHERE id=?", метод jdbc.update) -
     * удаления записи пользователя из БД по ID.
     */
    public void deleteById(int id){
        String querySql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(querySql, id);
    }

    /**
     * Обнавление User по id
     */
    public User updateById(User user){
        String querySql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbc.update(querySql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}
