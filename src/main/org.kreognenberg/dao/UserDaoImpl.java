package dao;

import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public User findById(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT id, username, email, beerkind, gender, interests FROM users WHERE id=:id";

        User result = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                new UserMapper());

        //new BeanPropertyRowMapper(Customer.class));

        return result;

    }

    private User lastAdded() {
        String sql = "SELECT * FROM users ORDER BY id DESC LIMIT 1;";
        User result = namedParameterJdbcTemplate.query(sql, new UserMapper()).get(0);

        return result;
    }

    public List<User> findAll() {

        String sql = "SELECT * FROM users";

        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());

        return result;

    }

    public User save(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", user.getUsername());
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());
        params.put("beerKind", user.getBeerKind());
        params.put("gender", user.getGender());
        params.put("interests", user.getInterests());

        String sql = "INSERT INTO users(username, email, password, beerkind, gender, interests) " +
                "values( :username, :email, :password, :beerKind, :gender, :interests)";

        namedParameterJdbcTemplate.update(sql, params);

        User user2 = lastAdded();
        return user2;
    }

    public User update(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", user.getUsername());
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());
        params.put("beerKind", user.getBeerKind());
        params.put("gender", user.getGender());
        params.put("id", user.getId());
        params.put("interests", user.getInterests());

        String sql = "UPDATE users SET username = :username, email = :email, password = :password, beerkind = :beerKind," +
                " gender = :gender, interests = :interests WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, params);

        User user2 = findById(user.getId());
        return user2;
    }

    public void delete(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "DELETE FROM users WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, params);
    }

    public User register(String username) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);

        String sql = "SELECT * FROM users WHERE username = :username limit 1";

        List<User> userList = namedParameterJdbcTemplate.query(sql, params, new UserMapper());
        if (userList.size() == 0)
        {
            return null;
        }
        else {
            return userList.get(0);
        }
    }


    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setBeerKind(rs.getString("beerkind"));
            user.setGender(rs.getString("gender"));
            user.setInterests(rs.getString("interests"));
            return user;
        }
    }

}