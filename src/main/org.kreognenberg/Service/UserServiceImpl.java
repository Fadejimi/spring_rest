package Service;

import Model.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


    @Override
    public User logUser(String username, String password) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        if (user.getId() == null) {
            user = userDao.save(user);
        } else {
            user = userDao.update(user);
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
