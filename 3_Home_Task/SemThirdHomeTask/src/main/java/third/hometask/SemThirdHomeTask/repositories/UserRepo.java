package third.hometask.SemThirdHomeTask.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import third.hometask.SemThirdHomeTask.domain.User;

import java.util.List;

/**
 * 2) Перенести репозиторий проекта с List<User> на базу данных H2
 *
 */
@Repository
public class UserRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<User> getAllUsers(){
        String query = "SELECT * FROM userTable";
        RowMapper<User> rowObject = (r, i) -> {
            User user = new User();
            user.setName(r.getString("name"));
            user.setAge(r.getInt("age"));
            user.setEmail(r.getString("email"));
            return user;
        };
        return jdbcTemplate.query(query, rowObject);
    }
    public User save(User user ){
        String query = "INSERT INTO userTable (name, age, email) VALUES(?,?,?)";
        jdbcTemplate.update(query, user.getName(), user.getAge(), user.getEmail());
        return user;
    }
}
