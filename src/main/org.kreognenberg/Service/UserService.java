package Service;

import Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User logUser(String username, String password);
    List<User> findAll();
    User findOne(Integer id);
    User saveOrUpdateUser(User user);
    void delete(Integer id);
}
