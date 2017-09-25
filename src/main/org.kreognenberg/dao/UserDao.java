package dao;

import Model.User;

import java.util.List;

public interface UserDao {
    User findById(Integer id);

    User save(User user);

    User update(User user);

    void delete(Integer id);

    List<User> findAll();

    User register(String username);
}
