package bo;

import Model.User;

import java.util.List;

public interface UserBo {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Integer id);
    User findUserById(Integer id);
    List<User> findAll();
}
