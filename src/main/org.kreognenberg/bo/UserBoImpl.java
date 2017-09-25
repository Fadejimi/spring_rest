package bo;

import Model.User;
import dao.UserDao;

import java.util.List;

public class UserBoImpl implements UserBo {
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
