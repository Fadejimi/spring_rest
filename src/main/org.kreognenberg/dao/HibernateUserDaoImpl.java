package dao;

import Model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

@Qualifier("userDao")
public class HibernateUserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public User findById(Integer id) {
        return (User) getHibernateTemplate().find("from User where id=?", id).get(0);
    }

    @Override
    public User save(User user) {
        getHibernateTemplate().save(user);

        return lastAdded();
    }

    private User lastAdded() {
        return (User) getHibernateTemplate().find("from User order by id desc").get(0);
    }

    @Override
    public User update(User user) {
        getHibernateTemplate().update(user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        User user = (User) getHibernateTemplate().find("from User where id = ?", id);

        getHibernateTemplate().delete(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) getHibernateTemplate().find("from User");
    }

    @Override
    public User register(String username) {
        List<User> users = (List<User>) getHibernateTemplate().find("from User where username = ?",
                username);

        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
