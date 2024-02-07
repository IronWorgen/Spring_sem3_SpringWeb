package hw.springWeb.repository;

import hw.springWeb.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий работающий с базой данных H2
 */
@Repository("h2")
@RequiredArgsConstructor
public class H2UserRepository implements iUserRepository {

    private final JdbcTemplate jdbcTemplate;


    /**
     * получить всех пользователей из базы данных H2
     *
     * @return список пользователей
     */
    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM users";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbcTemplate.query(sql, userRowMapper);
    }


    /**
     * добавить пользователя в базу данных H2
     *
     * @param user пользователь для добавления
     */
    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (name, age, email) values(?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
